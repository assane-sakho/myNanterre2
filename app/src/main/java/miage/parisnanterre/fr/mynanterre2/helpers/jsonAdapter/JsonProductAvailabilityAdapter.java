package miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import miage.parisnanterre.fr.mynanterre2.api.crous.ProductAvailability;

public class JsonProductAvailabilityAdapter implements JsonSerializer<ProductAvailability> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public JsonElement serialize(ProductAvailability productAvailability, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject obj = new JsonObject();

        obj.addProperty("id", productAvailability.getId());
        obj.addProperty("isAvailable", productAvailability.isAvailable());
        obj.addProperty("crousProduct", productAvailability.getCrousProduct().getUri());

        return obj;
    }
}