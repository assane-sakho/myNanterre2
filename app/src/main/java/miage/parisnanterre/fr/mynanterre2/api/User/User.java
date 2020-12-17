package miage.parisnanterre.fr.mynanterre2.api.User;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String lastName;
    private String firstName;

    public int getId() {
        return id;
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
}
