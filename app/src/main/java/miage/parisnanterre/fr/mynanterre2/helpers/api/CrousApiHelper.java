package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousApiHelper extends ApiHelper<SimpleCrous, Crous> {

    private static CrousApiHelper instance;
    private static String baseEndPoint = "crouses";

    private CrousApiHelper() {
        super(baseEndPoint, false);
    }

    public static CrousApiHelper getInstance()
    {
        if(instance == null)
            instance = new CrousApiHelper();
        return instance;
    }

    @Override
    List<SimpleCrous> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, SimpleCrous[].class));
    }

    @Override
    List<SimpleCrous> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, SimpleCrous[].class));
    }

    @Override
    Crous convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, Crous.class);
    }

    public SimpleCrous getSimpleCrous(int id)
    {
        return getSimpleElement(id);
    }

    public List<SimpleCrous> getAllSimpleCrous() throws ExecutionException, InterruptedException {
        return getAllSimpleElements();
    }
}
