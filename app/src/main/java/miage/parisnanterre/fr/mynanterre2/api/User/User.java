package miage.parisnanterre.fr.mynanterre2.api.user;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class User extends BaseDbElement {
    private String lastName;
    private String firstName;

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
}
