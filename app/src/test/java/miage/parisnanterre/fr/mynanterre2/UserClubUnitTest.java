package miage.parisnanterre.fr.mynanterre2;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.club.Type;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubTypeApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserClubApiHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UserClubUnitTest {

    @Test
    public void testFollowedClub() {
        UserApiHelper userApiHelper = UserApiHelper.getInstance(1);
        User userConnected = userApiHelper.getUserConnected();
        List<Integer> followedClubs = userConnected.getFollowedClubsIds();
        assertNotNull(followedClubs);
    }

    @Test
    public void testFollowedClubPublications() throws ExecutionException, InterruptedException {
        UserClubApiHelper userClubApiHelper = UserClubApiHelper.getInstance(0);
        List<Publication> publications = userClubApiHelper.getFollowedClubsPublication();
        assertNotNull(publications);
    }

    @Test
    public void testFollowUnfollowClub() throws IOException, ExecutionException, InterruptedException {
        UserApiHelper userApiHelper = UserApiHelper.getInstance(0);
        User userConnected = userApiHelper.getUserConnected();
        List<Integer> followedClubs = userConnected.getFollowedClubsIds();

        ClubTypeApiHelper clubTypeApiHelper = ClubTypeApiHelper.getInstance();

        Type clubType = clubTypeApiHelper.getAllTypes().get(0);

        SimpleClub simpleClub = new SimpleClub();
        simpleClub.setName("club de test")
                .setWebsite("www.mynanterre2.fr")
                .setContact("mynanterre2 - UPN")
                .setMail("mynanterre2@gmail.com")
                .setDescription("une description")
                .setType(clubType)
                .setCreator(userConnected);

        Club club = new Club(simpleClub);

        ClubApiHelper clubApiHelper = ClubApiHelper.getInstance();

        club = clubApiHelper.createClub(club);

        UserClubApiHelper userClubApiHelper = UserClubApiHelper.getInstance(0);
        UserClub userClub = userClubApiHelper.followClub(club);

        List<Integer> newFollowedClubs = userConnected.getFollowedClubsIds();
        assertNotEquals(followedClubs, newFollowedClubs);

        userClubApiHelper.unFollowClub(userClub);

        Assert.assertEquals(followedClubs, userConnected.getFollowedClubsIds());

        clubApiHelper.deleteClub(club);
    }

}
