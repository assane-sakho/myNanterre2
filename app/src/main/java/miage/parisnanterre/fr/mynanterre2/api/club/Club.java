package miage.parisnanterre.fr.mynanterre2.api.club;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import miage.parisnanterre.fr.mynanterre2.api.user.User;

public class Club extends SimpleClub {

    @SerializedName("clubPublications")
    private List<Publication> publications;

    public Club(SimpleClub simpleClub) {
        super(simpleClub.getName(),
                simpleClub.getImageBytes(),
                simpleClub.getImageUrl(),
                simpleClub.getCreationDate(),
                simpleClub.getDescription(),
                simpleClub.isCertificate(),
                simpleClub.isValidate(),
                simpleClub.getCreator(),
                simpleClub.getContact(),
                simpleClub.getMail(),
                simpleClub.getWebsite(),
                simpleClub.getType());

        id = simpleClub.getId();
        publications = new ArrayList<>();
    }

    public Club(String name, byte[] imageBytes, String imageUrl, LocalDateTime creationDate, String description, boolean isCertificate, boolean isValidate, User creator, String contact, String mail, String website, Type type) {
        super(name, imageBytes, imageUrl, creationDate, description, isCertificate, isValidate, creator, contact, mail, website, type);
        publications = new ArrayList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Club() {
        publications = new ArrayList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Club addPublication(String publicationMessage) {
        this.publications.add(new Publication(publicationMessage));
        return this;
    }

    public Club addPublication(Publication publication) {
        this.publications.add(publication);
        return this;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Publication> getPublications() {
        return publications;
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
