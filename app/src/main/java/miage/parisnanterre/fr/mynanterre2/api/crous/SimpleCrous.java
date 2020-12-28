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
    protected List<Schedule> crousSchedules;
    protected byte[] image;
    protected double longitude;
    protected double latitude;

    protected String produtcsNameConcat;

    @SerializedName("crousAttendance")
    protected List<Attendance> crousAttendances;

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

    public List<Attendance> getCrousAttendances() {
        return crousAttendances;
    }

    public void setCrousAttendances(List<Attendance> crousAttendances) {
        this.crousAttendances = crousAttendances;
    }

    public byte[] getImage() {
        return image;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getProductsNameConcat() {
        return produtcsNameConcat;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean isOpen() {
        return ScheduleHelper.isOpen((List<miage.parisnanterre.fr.mynanterre2.api.schedule.Schedule>)(List<?>) crousSchedules);
    }
}
