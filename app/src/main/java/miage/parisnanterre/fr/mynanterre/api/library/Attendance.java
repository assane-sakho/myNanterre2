package miage.parisnanterre.fr.mynanterre.api.library;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance extends LibraryRelatedElement{
    private int proportion;
    private LocalTime hour;

    public Attendance(int id, int proportion, LocalTime hour, Library library) {
        super(id, library);
        this.proportion = proportion;
        this.hour = hour;
    }
}
