package miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;

public class JsonUserClubAdapter implements JsonSerializer<UserClub> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public JsonElement serialize(UserClub userClub, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject obj = new JsonObject();

        obj.addProperty("id", userClub.getId());
        obj.addProperty("user", userClub.getUser().getUri());
        obj.addProperty("club", userClub.getClub().getUri());

        return obj;
    }
}