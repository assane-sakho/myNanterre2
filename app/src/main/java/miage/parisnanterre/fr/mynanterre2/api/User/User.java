package miage.parisnanterre.fr.mynanterre2.api.User;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String lastName;
    private String firstName;
    private LocalDateTime birthDate;
    private Grade grade;

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Grade getGrade() {
        return grade;
    }

    public Type getType() {
        return type;
    }

    public int getUniversityId() {
        return universityId;
    }

    @SerializedName("userType")
    private Type type;
    private int universityId;
}
