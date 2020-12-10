package miage.parisnanterre.fr.mynanterre2.api.club;

import com.google.gson.annotations.SerializedName;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.User.User;

public class Club {
    private int id;
    private String name;
    private byte[] image;
    private LocalDateTime creationDate;
    private String description;
    private boolean isCertificate;
    private boolean isValidate;
    private User creator;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCertificate() {
        return isCertificate;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public User getCreator() {
        return creator;
    }

    public Type getType() {
        return type;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    @SerializedName("clubType")
    private Type type;

    @SerializedName("clubPublications")
    private List<Publication> publications;
}
