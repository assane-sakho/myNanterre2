package miage.parisnanterre.fr.mynanterre2;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.club.Type;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubPublicationApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubTypeApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ClubPublicationUnitTest {

    @Test
    public void testApiCreateUpdateDelete() throws IOException, ExecutionException, InterruptedException {
        ClubTypeApiHelper clubTypeApiHelper = ClubTypeApiHelper.getInstance();

        List<Type> clubTypes= clubTypeApiHelper.getAllTypes();
        Type clubType = clubTypes.stream().findFirst().get();

        UserApiHelper userApiHelper = UserApiHelper.getInstance();
        User creator = userApiHelper.getUserConnected(); //user test

        SimpleClub simpleClub = new SimpleClub();
        simpleClub.setName("club de test")
                .setWebsite("www.mynanterre2.fr")
                .setContact("mynanterre2 - UPN")
                .setMail("mynanterre2@gmail.com")
                .setDescription("une description")
                .setType(clubType)
                .setCreator(creator);

        Club club = new Club(simpleClub);

        ClubApiHelper clubApiHelper = ClubApiHelper.getInstance();

        club = clubApiHelper.createClub(club);

        Publication publication = new Publication("un message.", club);
        Publication publication2 = new Publication("un deuxieme message", club);

        ClubPublicationApiHelper clubPublicationApiHelper = ClubPublicationApiHelper.getInstance();

        publication = clubPublicationApiHelper.createPublication(publication);
        publication2 = clubPublicationApiHelper.createPublication(publication2);

        assertNotEquals(0, publication.getId());
        assertNotEquals(0, publication2.getId());

        assertEquals(true, club.getPublications().contains(publication));
        assertEquals(true, club.getPublications().contains(publication2));

        String oldMessage = publication2.getMessage();
        publication2.setMessage("Un deuxième message.");
        publication2 = clubPublicationApiHelper.updatePublication(publication2);

        assertNotEquals(oldMessage, publication2);

        boolean isDelete = clubPublicationApiHelper.deletePublication(publication2);

        assertEquals(true, isDelete);
        assertEquals(false, club.getPublications().contains(publication2));

        clubApiHelper.deleteClub(club);
    }
}
