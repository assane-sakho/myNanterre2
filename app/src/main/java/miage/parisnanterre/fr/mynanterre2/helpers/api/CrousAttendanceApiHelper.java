package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.crous.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousAttendanceApiHelper extends ApiHelper<Attendance, Attendance> {
    private final static int LOW_ATTENDANCE = 30;
    private final static int MEDIUM_ATTENDANCE = 60;
    private final static int HIGH_ATTENDANCE = 100;

    private static CrousAttendanceApiHelper instance;
    private static String baseEndPoint = "crous_attendances";

    private CrousAttendanceApiHelper() {
        super(baseEndPoint, false);
    }

    public static CrousAttendanceApiHelper getInstance()
    {
        if(instance == null)
            instance = new CrousAttendanceApiHelper();
        return instance;
    }

    @Override
    List<Attendance> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, Attendance[].class));
    }

    @Override
    List<Attendance> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, Attendance[].class));
    }

    @Override
    Attendance convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, Attendance.class);
    }

    public Attendance getSimpleCrous(int id)
    {
        return getSimpleElement(id);
    }

    public List<Attendance> getMoreSimpleCrous()
    {
        return getMoreSimpleElements();
    }

    public void createLowAttendance(SimpleCrous simpleCrous) throws IOException {
        createAttendance(LOW_ATTENDANCE, simpleCrous);
    }

    public void createMediumAttendance(SimpleCrous simpleCrous) throws IOException {
        createAttendance(MEDIUM_ATTENDANCE, simpleCrous);
    }

    public void createHighAttendance(SimpleCrous simpleCrous) throws IOException {
        createAttendance(HIGH_ATTENDANCE, simpleCrous);
    }

    private void createAttendance(int proportion, SimpleCrous simpleCrous) throws IOException {
        Attendance attendance = new Attendance(proportion, new Crous(simpleCrous));
        simpleCrous.addAttendance(attendance);

        String jsonString = gson.toJson(attendance).replace("{\"id\":0,", "{"); //id is not used for insertion
        convertToComplete(sendData(jsonString, ApiRequestMethod.POST));
    }
}
