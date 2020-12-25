package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.user.User;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UserApiHelper extends ApiHelper<User, User> {

    private static UserApiHelper instance;
    private static String baseEndPoint = "users";

    private UserApiHelper() {
        super(baseEndPoint, true);
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

    public User getSimpleUser(int id)
    {
        return getSimpleElement(id);
    }

    public User getCompleteUser(int id)
    {
        return getCompleteElement(id);
    }

    public List<User> getMoreUsers()
    {
        return getMoreSimpleElements();
    }
}
