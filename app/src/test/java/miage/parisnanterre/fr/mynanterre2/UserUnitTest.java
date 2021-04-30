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
import miage.parisnanterre.fr.mynanterre2.helpers.api.LoginApiHelper;
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

//    @Test
//    public void testLogin() throws IOException, ExecutionException, InterruptedException {
//        LoginApiHelper loginApiHelper = LoginApiHelper.getInstance();
//
//        boolean isLoggeed = loginApiHelper.login("test@parisnanterre.fr", "P7dBsRCPtg5bf4vy4eePg");
//
//        assertEquals(true, isLoggeed);
//    }

//
//    @Test
//    public void testSignIn() throws IOException {
//        LoginApiHelper loginApiHelper = LoginApiHelper.getInstance();
//        boolean isSigned = loginApiHelper.signIn("test", "testeur2", "test@parisnanterre.fr", "P7dBsRCPtg5bf4vy4eePg");
//
//        assertEquals(true, isSigned);
//    }



}
