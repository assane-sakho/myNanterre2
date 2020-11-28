package miage.parisnanterre.fr.mynanterre.api.library;

import java.time.LocalTime;

public class Schedule extends LibraryRelatedElement {
    private LocalTime openingTime;
    private LocalTime closingTime;

    public Schedule(int id, String content, Library library) {
        super(id, content, library);
    }

}
