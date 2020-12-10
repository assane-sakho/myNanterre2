package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;

public class ClubApiHelper extends ApiHelper {
    private static ClubApiHelper instance = new ClubApiHelper();
    private List<Club> clubs;

    // Hide default constructor
    private ClubApiHelper(){
        clubs = new ArrayList<>();
    }

    public static ClubApiHelper getInstance()
    {
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Club> getClubs() {
        synchronized (clubs)
        {
            try {
                String jsonString = getJsonAsString("clubs");
                clubs = Arrays.asList(gson.fromJson(jsonString, Club[].class));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return clubs;
        }
    }
}
