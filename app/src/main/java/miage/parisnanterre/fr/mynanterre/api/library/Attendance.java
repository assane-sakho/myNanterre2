package miage.parisnanterre.fr.mynanterre.api.library;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalTime;

public class Attendance extends LibraryRelatedElement{
    private int proportion;
    private LocalTime hour;

    public Attendance(int id, int proportion, LocalTime hour, Library library) {
        super(id, library);
        this.proportion = proportion;
        this.hour = hour;
    }

    public int getProportion() {
        return proportion;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getHour() {
        return hour.getHour();
    }
}
