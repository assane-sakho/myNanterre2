package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.user.User;

@RequiresApi(api = Build.VERSION_CODES.O)
public class LoginApiHelper extends ApiHelper<User, User> {

    private static LoginApiHelper instance;
    private static String baseEndPoint = "login";
    private static String defaultToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2MTk3NzIwNjAsImV4cCI6MTY1MTkxMjg2MCwicm9sZXMiOlsiUk9MRV9VU0VSIl0sInVzZXJuYW1lIjoiYm90QHBhcmlzbmFudGVycmUuZnIifQ.Lspc4WWgvxBF9M1rdzt7CF8F_t65PRdL6MW-IQccKvRJWQXsu8o6UBfJBECqtrPZngf98iy1h3jIp1nHmjAmwLLNKz_-i1Jq6K-wo_ev_q_Hjj4-RqMdht2zC01U-IWrxUO7S7wwzl6atvT_teTE9wa6_86e1z6l8jRJtkYHc7dv0RQnv27n9Wu2NTJ0Rs98PgifhfL-z6EZczcl0jZORzPH4uHWkBndUlVvW88Etgc6EiexOHoPtxvXOG1v30vJKbMURuno2dMeNtn8CyJ8zuthGIxDLWnB3HFMzrdorUEgbi_j4qQUNeIdZbvFkX3IfgYd-L5lYyDOsVM2VfsccDlqpKMRkmGuEzsl4qdyaC63XM6tlIW2zdjBhuXs95w_EBV8uAjwTeUA5Ra2V8zRnREmnj6QvXTbdah1YrjRNVk3JwY093ZxtXFgiGlLVRG5wkpRaXwAfBNdELPVCr-ZqI9pJW4px5sFsNerJPLFD_azlNr7X_xjaWEpHbiIvoafGifd4V2m-FPB7WJdYwSppMiX6g6AANc3-7-LQEo-3kpPiRC_8ZniJDaOY6Xm9G7ySENMeetYAgnsyfDelREUWMlHYrwhvUL6R7jYwRTiHjfO_Aoim2FTqSBCttNSo8yA96xetpqx6BaVZfy-9le5cvrk3BYyAwu3cNPekLX_s9A";
    private static String userToken = "";

    private LoginApiHelper() {
        super(baseEndPoint, true);
    }

    public static LoginApiHelper getInstance()
    {
        if(instance == null)
            instance = new LoginApiHelper();
        return instance;
    }

    public boolean isUserAuthenticated(){
        return false;
    }

    public String getUserToken(){
        return isUserAuthenticated() ? userToken : defaultToken;
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
            return false;
        }
    }

    public boolean signIn(String firstName, String lastName, String email, String password) throws IOException {
        baseEndpointUrl = "users";
        User user = new User(firstName, lastName, email, password);
        String jsonString = gson.toJson(user).replace(",\"followedClubs\":[],\"userType\":{\"name\":\"student\",\"id\":0},\"id\":0", ""); //id is not used for insertion
       try {
           User userLogged = convertToComplete(sendData(jsonString, ApiRequestMethod.POST));
           SaveUserId(userLogged);
           return true;
       }
        catch (Exception e)
        {
            return  false;
        }
    }

    public void SaveUserToken(String token)
    {
        //TODO
    }

    public void SaveUserId(User user)
    {
        //TODO
    }

    public int getUserId()
    {
        //TODO
        return 0;
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
