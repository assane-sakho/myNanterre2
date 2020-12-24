package miage.parisnanterre.fr.mynanterre2.api.club;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;
import miage.parisnanterre.fr.mynanterre2.api.user.User;

public class SimpleClub extends NamedDbElement {
    protected byte[] imageBytes;
    protected String imageUrl;
    protected LocalDateTime creationDate;
    protected String description;
    protected boolean isCertificate;
    protected boolean isValidate;
    protected User creator;
    protected String contact;
    protected String mail;
    protected String website;
    @SerializedName("clubType")
    protected Type type;

    public String getContact() {
        return contact;
    }

    public String getMail() {
        return mail;
    }

    public String getWebsite() {
        return website;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public String getImageUrl() {
        return imageUrl;
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
