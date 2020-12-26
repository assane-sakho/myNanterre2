package miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import miage.parisnanterre.fr.mynanterre2.api.crous.Attendance;

public class JsonCrousAttendanceAdapter implements JsonSerializer<Attendance> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public JsonElement serialize(Attendance attendance, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject obj = new JsonObject();

        obj.addProperty("id", attendance.getId());
        obj.addProperty("proportion", attendance.getProportion());
        obj.addProperty("hour", attendance.getHour());
        obj.addProperty("crous", attendance.getCrous().getUri());

        return obj;
    }
}