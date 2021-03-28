package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UserClubApiHelper extends ApiHelper<UserClub, UserClub> {

    private static UserClubApiHelper instance;
    private static String baseEndPoint = "users_club";
    private ClubPublicationApiHelper clubPublicationApiHelper;
    private UserApiHelper userApiHelper;

    private UserClubApiHelper(int userId) {
        super(baseEndPoint, true);
        clubPublicationApiHelper = ClubPublicationApiHelper.getInstance();
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

    public void followClub(SimpleClub club) throws IOException {
        User userConnected = userApiHelper.getUserConnected();
        UserClub userClub = new UserClub(userConnected, club);

        String jsonString = gson.toJson(userClub).replace("{\"id\":0,", "{"); //id is not used for insertion
        String r = sendData(jsonString, ApiRequestMethod.POST);
        userClub = convertToComplete(r);
        userClub.getUser().addFollowedClub(userClub);
    }

    public void unFollowClub(UserClub userClub) throws IOException {
        String jsonString = gson.toJson(userClub);
        sendData(jsonString, ApiRequestMethod.DELETE, Optional.of(userClub.getId()));
        userClub.getUser().removeFollowedClub(userClub);
    }

    public List<Publication> getFollowedClubsPublication() throws InterruptedException, ExecutionException {
        User userConnected = userApiHelper.getUserConnected();
        String ids = userConnected.getFollowedClubsIds().stream().map(String::valueOf).collect(Collectors.joining("%2C"));
        List<Publication> publications = clubPublicationApiHelper.getAllPublications(ids);
        publications.sort((p1, p2) -> p2.getDate().compareTo(p1.getDate()));
        return publications;
    }
}
