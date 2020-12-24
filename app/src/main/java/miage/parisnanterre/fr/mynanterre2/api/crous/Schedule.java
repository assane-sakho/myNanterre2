package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class Schedule extends BaseDbElement {
    private String days;
    private LocalTime openingTime;
    private LocalTime closingTime;

    public String getDays() {
        return days;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }
}
