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

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UserClubApiHelper extends ApiHelper<UserClub, UserClub> {

    private static UserClubApiHelper instance;
    private static String baseEndPoint = "users_club";
    private ClubPublicationApiHelper clubPublicationApiHelper;

    private UserClubApiHelper() {
        super(baseEndPoint, true);
        clubPublicationApiHelper = ClubPublicationApiHelper.getInstance();
    }

    public static UserClubApiHelper getInstance()
    {
        if(instance == null)
            instance = new UserClubApiHelper();
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

    public void followClub(UserClub userClub) throws IOException {
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

    private class ElementsCallable implements Callable<List<Publication>> {
        private final int clubId;

        public ElementsCallable(int clubId) {
            this.clubId = clubId;
        }

        public List<Publication> call() throws ExecutionException, InterruptedException {
            return clubPublicationApiHelper.getAllPublications(clubId);
        }
    }

    public List<Publication> getFollowedClubsPublication(User user) throws InterruptedException, ExecutionException {
        List<Publication> publications = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(user.getFollowedClubsIds().size());

        List<ElementsCallable> callableTasks = new ArrayList<>();

        for (int clubId: user.getFollowedClubsIds()) {
            callableTasks.add(new ElementsCallable(clubId));
        }

        List<Future<List<Publication>>> futures = executorService.invokeAll(callableTasks);

        for (Future<List<Publication>> f : futures)
            publications.addAll(f.get());

        return publications;
    }
}
