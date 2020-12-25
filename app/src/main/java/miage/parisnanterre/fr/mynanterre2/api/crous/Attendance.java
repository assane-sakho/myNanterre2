package miage.parisnanterre.fr.mynanterre2.api.crous;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.crous.CrousRelatedElement;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Attendance extends CrousRelatedElement {
    private int proportion;
    private LocalTime hour;

    public Attendance(int proportion, Crous crous) {
        super(crous);
        this.proportion = proportion;
        this.hour = LocalTime.now();
    }

    public int getProportion() {
        return proportion;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getHour() {
        return hour.getHour();
    }
}
