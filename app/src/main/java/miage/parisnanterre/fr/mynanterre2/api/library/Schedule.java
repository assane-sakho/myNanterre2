package miage.parisnanterre.fr.mynanterre2.api.library;

import java.time.LocalTime;

public class Schedule extends LibraryRelatedElement {
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String days;

    public Schedule(int id, LocalTime openingTime, LocalTime closingTime, Library library, String days) {
        super(id, library);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.days = days;
    }

}
