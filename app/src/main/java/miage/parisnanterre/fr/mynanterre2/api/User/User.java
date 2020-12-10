package miage.parisnanterre.fr.mynanterre2.api.User;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String lastName;
    private String firstName;
//    private LocalDateTime birthDate;

    @SerializedName("grade")
    private Grade grade;
    @SerializedName("userType")
    private Type type;
    private int universityId;
}
