package miage.parisnanterre.fr.mynanterre2.api.club;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.Objects;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;
import miage.parisnanterre.fr.mynanterre2.api.user.User;

public class SimpleClub extends NamedDbElement {
    private static final String EMPTY_STRING = "";

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

    public SimpleClub(String name, byte[] imageBytes, String imageUrl, LocalDateTime creationDate, String description, boolean isCertificate, boolean isValidate, User creator, String contact, String mail, String website, Type type) {
        super(name);
        this.imageBytes = imageBytes;
        this.imageUrl = imageUrl;
        this.creationDate = creationDate;
        this.description = description;
        this.isCertificate = isCertificate;
        this.isValidate = isValidate;
        this.creator = creator;
        this.contact = contact;
        this.mail = mail;
        this.website = website;
        this.type = type;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public SimpleClub() {
        super(EMPTY_STRING);
        this.imageBytes = EMPTY_STRING.getBytes();
        this.imageUrl = EMPTY_STRING;
        this.creationDate = LocalDateTime.now();
        this.description = EMPTY_STRING;
        this.isCertificate = false;
        this.isValidate = false;
        this.creator = new User(EMPTY_STRING, EMPTY_STRING, new miage.parisnanterre.fr.mynanterre2.api.user.Type(EMPTY_STRING));
        this.contact = EMPTY_STRING;
        this.mail = EMPTY_STRING;
        this.website = EMPTY_STRING;
        this.type = new Type(EMPTY_STRING);
    }

    public SimpleClub setName(String name) {
        this.name = name;
        return this;
    }

    public SimpleClub setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
        return this;
    }

    public SimpleClub setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public SimpleClub setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public SimpleClub setDescription(String description) {
        this.description = description;
        return this;
    }

    public SimpleClub setCertificate(boolean certificate) {
        isCertificate = certificate;
        return this;
    }

    public SimpleClub setValidate(boolean validate) {
        isValidate = validate;
        return this;
    }

    public SimpleClub setCreator(User creator) {
        this.creator = creator;
        return this;
    }

    public SimpleClub setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public SimpleClub setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public SimpleClub setWebsite(String website) {
        this.website = website;
        return this;
    }

    public SimpleClub setType(Type type) {
        this.type = type;
        return this;
    }

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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
