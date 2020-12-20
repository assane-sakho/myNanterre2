package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubApiHelper extends ApiHelper<SimpleClub, Club> {

    private static ClubApiHelper instance;
    private static String baseEndPoint = "clubs";

    private ClubApiHelper() {
        super(baseEndPoint);
    }

    public static ClubApiHelper getInstance()
    {
        if(instance == null)
            instance = new ClubApiHelper();
        return instance;
    }

    @Override
    List<SimpleClub> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, Club[].class));
    }

    @Override
    List<SimpleClub> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, Club[].class));
    }

    @Override
    Club convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, Club.class);
    }

    public List<SimpleClub> getSimpleClubs() throws ExecutionException, InterruptedException {
        return getSimpleElements();
    }

    public SimpleClub getSimpleClub(int id)
    {
        return getSimpleElement(id);
    }

    public Club getClub(SimpleClub simpleClub)
    {
        Club club = new Club(simpleClub);

        return club;
    }

}
