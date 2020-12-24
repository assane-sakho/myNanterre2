package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class Schedule extends miage.parisnanterre.fr.mynanterre2.api.schedule.Schedule {
    private Crous crous;
    public Schedule(int id, LocalTime openingTime, LocalTime closingTime, String days, Crous crous) {
        super(id, openingTime, closingTime, days);
        this.crous = crous;
    }
}
