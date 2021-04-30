package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.helpers.MyApplication;

import static android.content.Context.MODE_PRIVATE;

@RequiresApi(api = Build.VERSION_CODES.O)
public class LoginApiHelper extends ApiHelper<User, User> {

    private static LoginApiHelper instance;
    private static String baseEndPoint = "login";
    private static String defaultToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2MTk4MDQ0MjQsImV4cCI6MTY1MTk0NTIyNCwicm9sZXMiOlsiUk9MRV9VU0VSIl0sInVzZXJuYW1lIjoiYm90QHBhcmlzbmFudGVycmUuZnIifQ.AuNvTTbk-nXylKl-JWcbJwrtmxUEdUlCSdS3q7js2Cg_ZqPgQueaynz8OQuUng2f0G_Rto5MpMuojZQP8qKdxG6vEBndFb87JHYqwReiD1TpVyU3hvKnL5cSDOf96uuFwaXrwp3b9rcvAjtpYwgz9bTvpFF9S8lqaS_iCLeiQOYGkJXAkTL04pMFkWJc3rI65tYeBBbKPuQzAyuRv9ZdFlxd3e65wXKI-lu4LBHqgswSZUAIAT3ynQv2yONbyY3pcrTCbVAjD6tAkl1YRVspxO-OIvlvIctNcbtyOifV3_EymU7NTLvA0HXXTvdEcuZw6LleCqsMRTL3973tKdcldxROthRvgtDzs0za0tfRWwngsLXzFgE-vkwE0UrC-nsSiPZjRHYnBZ8Psh8HWvNWqucsyRdnFa5z18kUrQe9AXmOSoQlAqR_cQEP5N1UsxPcNCNcqOXIomPh0DVWoaZq7mepwaeMupi_wNZHfYgaKuw9zJi0WAaRaWukdlkaoS0bCgqbVi1HwRBcbZMDkzVy3TXki4yH7TZrhv1sP2irqjycLPprto2D2mZAL8lTrUMNnPe48fpwNvaCyNS1vP9d6azzlpJo444gtzGLVnN8U7XiuuzPY7je4EOt0Cm-OI6y_NuiO3OWXeTpf_75P44YTJZh2Nhuzre6RnorxssYjUE";
    private SharedPreferences userDetails;

    private LoginApiHelper() {
        super(baseEndPoint, true);
        Context context = MyApplication.getAppContext();

        userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
    }

    public static LoginApiHelper getInstance()
    {
        if(instance == null)
            instance = new LoginApiHelper();
        return instance;
    }

    public boolean isUserAuthenticated(){
        boolean b1 = userDetails.getString("token", "").length() != 0;
        boolean b2 = userDetails.getString("userId", "").length() !=0;
        return b1 && b2;
    }

    public boolean login(String email, String password){
        baseEndpointUrl = baseEndPoint;

        String jsonString = "{\"email\" : \"" + email + "\",\"password\" : \"" + password + "\"}";
        try {
            String token = sendData(jsonString, ApiRequestMethod.POST);

            UserApiHelper userApiHelper = UserApiHelper.getInstance();
            User userLogged = userApiHelper.getUser(email);

            userApiHelper.setUserConnected(userLogged);

            SaveUserToken(token);
            SaveUserId(userLogged);

            return true;
        }
        catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }

    public boolean signIn(String firstName, String lastName, String email, String password) throws IOException {
        baseEndpointUrl = "users";
        User user = new User(firstName, lastName, email, password);
        String jsonString = gson.toJson(user).replace("{\"id\":0,", "{"); //id is not used for insertion
        try {
            sendData(jsonString, ApiRequestMethod.POST);
            return login(email, password);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return  false;
        }
    }

    public void logout()
    {
        SharedPreferences.Editor edit = userDetails.edit();
        edit.remove("userId");
        edit.remove("token");
        edit.apply();
    }

    public String getUserToken()
    {
        String token = userDetails.getString("token", defaultToken);
        return token;
    }

    public void SaveUserToken(String jsonToken)
    {
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(jsonToken).getAsJsonObject();
        String token = obj.get("token").getAsString();

        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("token", token);
        edit.apply();
    }

    public void SaveUserId(User user)
    {
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("userId", "" + user.getId());
        edit.apply();
    }

    public int getUserId()
    {
        String userId = userDetails.getString("userId", "");
        return Integer.valueOf(userId);
    }

    @Override
    List<User> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, User[].class));
    }

    @Override
    List<User> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, User[].class));
    }

    @Override
    User convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, User.class);
    }

}
