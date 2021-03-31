package miage.parisnanterre.fr.mynanterre2.api.user;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class User extends BaseDbElement {
    private String lastName;
    private String firstName;
    private boolean isConnected;
    private List<Integer> listClubFollow;

    public User(String lastName, String firstName, Type type) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.type = type;
        this.isConnected = false;
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

    @SerializedName("userType")
    private Type type;

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public boolean getIsConnected(){ return this.isConnected; }

    public void logOn(){ this.isConnected = true; }

    public void logOut(){ this.isConnected = false; }



}
