package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class ProductAvailability extends BaseDbElement {
    private boolean isAvailable;
    private LocalTime date;

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalTime getDate() {
        return date;
    }
}
