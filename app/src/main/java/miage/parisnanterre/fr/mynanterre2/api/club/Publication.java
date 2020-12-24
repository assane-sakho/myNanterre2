package miage.parisnanterre.fr.mynanterre2.api.club;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Objects;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class Publication extends BaseDbElement {
    private String message;
    private LocalDateTime date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Publication(String message) {
        this.message = message;
        date = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
