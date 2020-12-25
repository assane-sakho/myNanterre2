package miage.parisnanterre.fr.mynanterre2.api.crous;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;
import miage.parisnanterre.fr.mynanterre2.api.schedule.Schedulable;
import miage.parisnanterre.fr.mynanterre2.helpers.ScheduleHelper;

public class SimpleCrous extends NamedDbElement implements Schedulable {
    protected String location;
    private List<Schedule> crousSchedules;

    private List<Attendance> crousAttendances;

    public SimpleCrous()
    {
        crousSchedules = new ArrayList();
        crousAttendances = new ArrayList();
    }
    public String getLocation() {
        return location;
    }

    public List<Schedule> getCrousSchedules() {
        return crousSchedules;
    }

    public void addAttendance(Attendance attendance) {
        this.crousAttendances.add(attendance);
    }

    public void setCrousSchedules(List<Schedule> crousSchedules) {
        this.crousSchedules = crousSchedules;
    }

    public List<Attendance> getCrousAttendances() {
        return crousAttendances;
    }

    public void setCrousAttendances(List<Attendance> crousAttendances) {
        this.crousAttendances = crousAttendances;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean isOpen() {
        return ScheduleHelper.isOpen((List<miage.parisnanterre.fr.mynanterre2.api.schedule.Schedule>)(List<?>) crousSchedules);
    }
}
