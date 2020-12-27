package miage.parisnanterre.fr.mynanterre2.implem.crous.activity;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.fragment.CrousFragment;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubInfoFragment;
import miage.parisnanterre.fr.mynanterre2.implem.crous.fragment.CrousAttendanceFragment;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousAttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_info_activity);

        if (savedInstanceState == null) {
            int v = getIntent().getIntExtra("clickedSimpleCrousId", 0);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CrousAttendanceFragment.newInstance(v))
                    .commitNow();
        }
    }
}