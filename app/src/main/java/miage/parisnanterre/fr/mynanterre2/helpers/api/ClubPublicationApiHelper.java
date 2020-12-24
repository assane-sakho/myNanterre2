package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubPublicationApiHelper extends ApiHelper<Publication, Publication> {

    private static ClubPublicationApiHelper instance;
    private static final String baseFinalEndPoint = "club_publications";

    private ClubPublicationApiHelper() {
        super(baseFinalEndPoint, false, true, true);
    }

    public static ClubPublicationApiHelper getInstance()
    {
        if(instance == null)
            instance = new ClubPublicationApiHelper();
        return instance;
    }

    @Override
    List<Publication> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, Publication[].class));
    }

    @Override
    List<Publication> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, Publication[].class));
    }

    @Override
    Publication convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, Publication.class);
    }

    public List<Publication> getAllPublications(int clubId) throws ExecutionException, InterruptedException {
        baseEndpointUrl = baseFinalEndPoint + "?club=" + clubId;
        return getAllSimpleElements();
    }
}
