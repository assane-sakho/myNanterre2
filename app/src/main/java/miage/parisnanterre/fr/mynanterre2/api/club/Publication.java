package miage.parisnanterre.fr.mynanterre2.api.club;

import java.time.LocalDateTime;

public class Publication extends ClubRelatedElement{
    private String message;
    private LocalDateTime date;

    public Publication(int id, Club club) {
        super(id, club);
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
