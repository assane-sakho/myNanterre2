package miage.parisnanterre.fr.mynanterre2.api.club;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

import miage.parisnanterre.fr.mynanterre2.api.User.User;
import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class SimpleClub extends BaseDbElement {
    private byte[] image;
    private LocalDateTime creationDate;
    private String description;
    private boolean isCertificate;
    private boolean isValidate;
    private User creator;
    private String contact;
    private String mail;
    private String website;
    @SerializedName("clubType")
    private Type type;

    public String getContact() {
        return contact;
    }

    public String getMail() {
        return mail;
    }

    public String getWebsite() {
        return website;
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
}
