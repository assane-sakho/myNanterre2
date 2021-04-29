package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UserClubApiHelper extends ApiHelper<UserClub, UserClub> {

    private static UserClubApiHelper instance;
    private static String baseEndPoint = "users_clubs";
    private ClubApiHelper clubApiHelper;
    private UserApiHelper userApiHelper;

    public UserClubApiHelper(int userId) {
        super(baseEndPoint, true);
        clubApiHelper = ClubApiHelper.getInstance();
        userApiHelper = UserApiHelper.getInstance(userId);
    }

    public static UserClubApiHelper getInstance(int userId)
    {
        if(instance == null)
            instance = new UserClubApiHelper(userId);
        return instance;
    }

    @Override
    List<UserClub> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, UserClub[].class));
    }

    @Override
    List<UserClub> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, UserClub[].class));
    }

    @Override
    UserClub convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, UserClub.class);
    }

    public UserClub followClub(SimpleClub club) throws IOException {
        User userConnected = userApiHelper.getUserConnected();
        UserClub userClub = new UserClub(userConnected, club);

        String jsonString = gson.toJson(userClub).replace("{\"id\":0,", "{"); //id is not used for insertion
        String r = sendData(jsonString, ApiRequestMethod.POST);
        String id = gson.fromJson(r, HashMap.class).get("id").toString().replace(".0", "");
        userClub.setId(Integer.parseInt(id));
        userClub.getUser().addFollowedClub(userClub);
        return userClub;
    }

    public void unFollowClub(SimpleClub simpleClub) throws IOException {
        Optional<UserClub> userClub= userApiHelper.getUserConnected().getUserClub(simpleClub);

        if(userClub.isPresent()){
            userClub.get().setUser(userApiHelper.getUserConnected());
            String jsonString = gson.toJson(userClub.get());
            userClub.get().getUser().removeFollowedClub(userClub.get());
            sendData(jsonString, ApiRequestMethod.DELETE, Optional.of(userClub.get().getId()));
        }
    }


    private class ElementsCallable implements Callable<Club> {
        private final int clubId;

        public ElementsCallable(int clubId) {
            this.clubId = clubId;
        }

        public Club call(){
            return clubApiHelper.getCompleteElement(clubId);
        }
    }

    public List<Publication> getFollowedClubsPublication() throws InterruptedException, ExecutionException {
        User userConnected = userApiHelper.getUserConnected();
        List<Integer> ids = userConnected.getFollowedClubsIds();

        ExecutorService executorService = Executors.newFixedThreadPool(ids.size());

        List<ElementsCallable> callableTasks = new ArrayList<>();

        for (int clubId: ids) {
            callableTasks.add(new ElementsCallable(clubId));
        }

        List<Future<Club>> futures = executorService.invokeAll(callableTasks);
        List<Club> clubs = new ArrayList<>();

        for (Future<Club> f : futures)
        {
            Club c = f.get();
            c.getPublications().forEach(p -> p.setClub(c));
            clubs.add(c);
        }

        List<Publication> publications = clubs.stream().flatMap(c -> c.getPublications().stream()).collect(Collectors.toList());
        publications.sort((p1, p2) -> p2.getDate().compareTo(p1.getDate()));
        return publications;
    }
}
