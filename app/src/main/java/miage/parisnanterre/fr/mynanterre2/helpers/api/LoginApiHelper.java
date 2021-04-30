package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

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
    private static String defaultToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2MTk3ODIxMDEsImV4cCI6MTY1MTkyMjkwMSwicm9sZXMiOlsiUk9MRV9VU0VSIl0sInVzZXJuYW1lIjoiYm90QHBhcmlzbmFudGVycmUuZnIifQ.Aby2bfubk8rejDYn5-IxPtWi_ujo7U-3leskfTz-7Yh2B9btbLnMRMBoRbPFKite3xZ6fJoW9o3ZmGlINQSJ9sTOa0z665_I3EAAyCiPfinvzAQdFpOnFLsbvpoljMwsoTCf0Xfr35JU5ZQMWwMtGerohRNeiVqW13OFsWZFyuBIHL6bMJVRShw4VH0v6Y_4cCz3Ec_HVMe99buj5ti3uPmvfQjEs-AHg6tgDiHLENFSpuQNTv03z-BU6Jnx222uyZ-4epTSQWi8R8V6CvMV4AMsv3SbCmNBxl1whh73SE55_UL_zBz4D8ZEBWKLWiznuyTAvrgPHSWcV3ItgMNcjDjTHzPg2D2GXRsc6Js_CMHuh94sPkW5542pCqAXb7RS8uXivYdvaECd0qXUhm-Vf3KjxVRI643HfByBJd2AJVWROx1nbx5wjMzCnO9dvJ5-cfTtB5tvsD0p_2-iDhLFtU7FnroKWDztMHaBdYiSATDJqkQITh5xt26IUgFsVSmpdkojRW1i1W6JssC98hYqJskCP1Z8937xAfEIHs9GYmntP__-TE7LDUj3XQHzohEvN0ycW3iOh0I-CXmOtzz9bAVSaiOElb_FODXf7s54j8X_HmvZ6vrFuJZojBtdTYqSiUWWWHJd0SbW_pcJCkLNsyZGIBMJPto1BwVdZQr8Tw8";
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
        return userDetails.getString("token", defaultToken).length() != 0 && userDetails.getString("userId", defaultToken).length() != 0;
    }

    public String getUserToken(){
        return isUserAuthenticated() ? GetUserToken() : defaultToken;
    }

    public boolean login(String email, String password){
        baseEndpointUrl = baseEndPoint;

        String jsonString = "{\"email\" : \"" + email + "\",\"password\" : \"" + password + "\"}";
        try {
            String token = sendData(jsonString, ApiRequestMethod.POST);

            UserApiHelper userApiHelper = UserApiHelper.getInstance();
            User userLogged = userApiHelper.getUser(email);

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

    public String GetUserToken()
    {
        return userDetails.getString("token", defaultToken);
    }

    public void SaveUserToken(String token)
    {
        String tmpToken = token.replace("{\"token\":\"", "").replace("\"}", "");
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("token", tmpToken);
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
        return Integer.valueOf(userDetails.getString("userId", ""));
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
