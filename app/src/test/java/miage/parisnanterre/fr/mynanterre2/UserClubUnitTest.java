package miage.parisnanterre.fr.mynanterre2;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserClubApiHelper;

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
        UserClubApiHelper userClubApiHelper = UserClubApiHelper.getInstance(1);
        List<Publication> publications = userClubApiHelper.getFollowedClubsPublication();
        assertNotNull(publications);
    }

}
