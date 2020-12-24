package miage.parisnanterre.fr.mynanterre2.helpers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import miage.parisnanterre.fr.mynanterre2.api.crous.Schedule;

public class ScheduleHelper {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean isOpen(List<Schedule> schedules) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        String currentDay = new SimpleDateFormat("EE", Locale.ENGLISH).format(currentDate.getTime()).toUpperCase();
        LocalTime now = LocalTime.now();

        for(Schedule schedule : schedules)
        {
            String[] days = schedule.getDays().split("-");
            if (!Arrays.stream(days).anyMatch(currentDay::equals))
                continue;

            if(schedule.getOpeningTime().compareTo(now) < 0 && schedule.getClosingTime().compareTo(now) > 0 )
                return true;
        }
        return false;
    }
}
