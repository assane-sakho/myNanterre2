package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UserApiHelper extends ApiHelper<User, User> {

    private static UserApiHelper instance;
    private static String baseEndPoint = "users";
    private User userConnected;

    private UserApiHelper() {
        super(baseEndPoint, true);
        userConnected = null;
    }

    public static UserApiHelper getInstance()
    {
        if(instance == null)
            instance = new UserApiHelper();
        return instance;
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

    public User getCompleteUser(int id)
    {
        return getCompleteElement(id);
    }

    protected User getUser(String email) throws ExecutionException, InterruptedException {
        baseEndpointUrl = "users?email=" + URLEncoder.encode(email);
        parametersCompleter = '&';
        List<User> users = getAllSimpleElements();
        baseEndpointUrl = "users";
        parametersCompleter = '?';

        return users.get(0);
    }

    public User getUserConnected() {
        LoginApiHelper loginApiHelper = LoginApiHelper.getInstance();
        if(loginApiHelper.isUserAuthenticated())
        {
            userConnected = getCompleteUser(loginApiHelper.getUserId());
        }
        return userConnected;
    }
}
