package miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.user.User;

public class JsonUserAdapter implements JsonSerializer<User> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public JsonElement serialize(User user, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject obj = new JsonObject();

        obj.addProperty("id", user.getId());
        obj.addProperty("firstName", user.getFirstName());
        obj.addProperty("lastName", user.getLastName());
        obj.addProperty("email", user.getEmail());
        obj.addProperty("password", user.getPassword());

        return obj;
    }
}