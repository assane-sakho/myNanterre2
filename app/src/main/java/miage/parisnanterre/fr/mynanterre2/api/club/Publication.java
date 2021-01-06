package miage.parisnanterre.fr.mynanterre2.api.club;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Objects;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class Publication extends ClubRelatedElement {
    private String message;
    private LocalDateTime date;
    private Boolean isEdited;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Publication(String message, Club club) {
        this.message = message;
        date = LocalDateTime.now();
        isEdited = false;
        this.club = club;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Boolean isEdited() {
        return isEdited;
    }

    public Publication setMessage(String message) {
        this.message = message;
        isEdited = true;
        return this;
    }

    public Publication setEdited(Boolean edited) {
        isEdited = edited;
        return this;
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
