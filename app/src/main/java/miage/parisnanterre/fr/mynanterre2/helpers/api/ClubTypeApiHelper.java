package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Type;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubTypeApiHelper extends ApiHelper<Type, Type> {

    private static ClubTypeApiHelper instance;
    private static final String baseFinalEndPoint = "club_types";

    private ClubTypeApiHelper() {
        super(baseFinalEndPoint, false);
    }

    public static ClubTypeApiHelper getInstance()
    {
        if(instance == null)
            instance = new ClubTypeApiHelper();
        return instance;
    }

    @Override
    List<Type> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, Type[].class));
    }

    @Override
    List<Type> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, Type[].class));
    }

    @Override
    Type convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, Type.class);
    }

    public List<Type> getAllTypes() throws ExecutionException, InterruptedException {
        return getAllSimpleElements();
    }
}

