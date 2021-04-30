package miage.parisnanterre.fr.mynanterre2.api.user;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;
@RequiresApi(api = Build.VERSION_CODES.N)
public class User extends BaseDbElement {
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private List<UserClub> followedClubs;
    @SerializedName("userType")
    private Type type;

    public User(String lastName, String firstName, Type type) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.type = type;
        followedClubs = new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String password) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.type = new Type("student");
        followedClubs = new ArrayList<>();
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Type getType() {
        return type;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public List<Integer> getFollowedClubsIds()
    {
        return followedClubs.stream().map(UserClub::getClubId).collect(Collectors.toList());
    }

    public Optional<UserClub> getUserClub(SimpleClub club)
    {
        return followedClubs.stream().filter(c -> c.getClubId() == club.getId()).findFirst();
    }

    public void addFollowedClub(UserClub userClub)
    {
        followedClubs.add(userClub);
    }

    public void removeFollowedClub(UserClub userClub)
    {
        followedClubs.remove(userClub);
    }
}
