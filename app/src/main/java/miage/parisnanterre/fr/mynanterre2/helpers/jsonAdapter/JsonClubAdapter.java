package miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;

public class JsonClubAdapter implements JsonSerializer<Club> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public JsonElement serialize(Club club, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject obj = new JsonObject();

        obj.addProperty("id", club.getId());
        obj.addProperty("name", club.getName());
        obj.addProperty("description", club.getDescription());
        obj.addProperty("isCertificate", club.isCertificate());
        obj.addProperty("isValidate", club.isValidate());
        obj.addProperty("creator", club.getCreator().getUri());
        obj.addProperty("clubType", club.getType().getUri());
        obj.addProperty("contact", club.getContact());
        obj.addProperty("website", club.getWebsite());
        obj.addProperty("mail", club.getMail());

        return obj;
    }
}