package miage.parisnanterre.fr.mynanterre2.api.crous;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.schedule.Schedulable;

public class Crous extends SimpleCrous implements Schedulable {
    private List<CrousProduct> crousProducts;
    private List<Schedule> crousSchedules;

    public List<CrousProduct> getCrousProducts() {
        return crousProducts;
    }

    public List<Schedule> getCrousSchedules() {
        return crousSchedules;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean isOpen() {
        return ScheduleHelper.isOpen(crousSchedules);
    }
}
