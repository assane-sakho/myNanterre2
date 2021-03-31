package miage.parisnanterre.fr.mynanterre2.api.user;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;
@RequiresApi(api = Build.VERSION_CODES.N)
public class User extends BaseDbElement {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private List<UserClub> followedClubs;
    @SerializedName("userType")
    private Type type;

    public User(String lastName, String firstName, String email, String password, Type type) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.type = type;
        followedClubs = new ArrayList<>();
    }

    public String getEmail(){ return email; }

    public String getPassword() { return password; }

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

    public void addFollowedClub(UserClub userClub)
    {
        followedClubs.add(userClub);
    }

    public void removeFollowedClub(UserClub userClub)
    {
        followedClubs.remove(userClub);
    }
}
