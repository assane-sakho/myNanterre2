package miage.parisnanterre.fr.mynanterre2.api.club;

import com.google.gson.annotations.SerializedName;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Club extends SimpleClub {
    public Club(SimpleClub simpleClub) {
        id = simpleClub.getId();
        image = simpleClub.image;
        creationDate = simpleClub.creationDate;
        description = simpleClub.description;
        isCertificate = simpleClub.isCertificate;
        isValidate = simpleClub.isValidate;
        creator = simpleClub.creator;
        contact = simpleClub.contact;
        mail = simpleClub.mail;
        website = simpleClub.website;
        type = simpleClub.type;
        publications = new ArrayList<>();
    }


    @SerializedName("clubPublications")
    private List<Publication> publications;

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Publication> getPublications() {
        return publications;
    }

}
