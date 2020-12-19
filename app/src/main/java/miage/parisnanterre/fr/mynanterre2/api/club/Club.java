package miage.parisnanterre.fr.mynanterre2.api.club;

import com.google.gson.annotations.SerializedName;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.User.User;

public class Club extends SimpleClub {
    @SerializedName("clubPublications")
    private List<Publication> publications;

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Publication> getPublications() {
        return publications;
    }

}
