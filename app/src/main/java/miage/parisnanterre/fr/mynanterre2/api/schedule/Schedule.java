package miage.parisnanterre.fr.mynanterre2.api.schedule;

import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class Schedule extends BaseDbElement {
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String days;

    public Schedule(int id, LocalTime openingTime, LocalTime closingTime, String days) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.days = days;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public String getDays() {
        return days;
    }
}
