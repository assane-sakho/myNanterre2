package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.time.LocalDateTime;
import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class ProductAvailability extends BaseDbElement {
    private boolean isAvailable;
    private LocalDateTime date;

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
