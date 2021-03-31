package miage.parisnanterre.fr.mynanterre2.api.user;

import java.util.Optional;

import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class UserClub extends BaseDbElement {
    private SimpleClub club;
    private User user;

    public UserClub(User user, SimpleClub club) {
        this.user = user;
        this.club = club;
    }


    public UserClub(int id, User user, SimpleClub club) {
        this.user = user;
        this.id = id;
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public SimpleClub getClub() {
        return club;
    }

    public int getClubId() {
        return club.getId();
    }
}
