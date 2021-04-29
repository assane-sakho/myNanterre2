package miage.parisnanterre.fr.mynanterre2;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
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
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubTypeApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UserUnitTest {

    @Test
    public void testConnectedUser() {
        UserApiHelper userApiHelper = UserApiHelper.getInstance();
        User userConnected = userApiHelper.getUserConnected();

        assertNotNull(userConnected);
    }


}
