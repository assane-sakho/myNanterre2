package miage.parisnanterre.fr.mynanterre2.implem.crous.activity;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.fragment.CrousFragment;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubInfoFragment;
import miage.parisnanterre.fr.mynanterre2.implem.crous.fragment.CrousAttendanceFragment;
import miage.parisnanterre.fr.mynanterre2.implem.crous.fragment.CrousMenuFragment;
import miage.parisnanterre.fr.mynanterre2.implem.crous.fragment.CrousProductAvaiabilityFragment;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_info_activity);

        if (savedInstanceState == null) {
            String nextFragment = getIntent().getStringExtra("nextFragment");

            Fragment fragmentClass;
            switch (nextFragment)
            {
                case "CrousAttendanceFragment" :
                    fragmentClass = CrousAttendanceFragment.newInstance(getIntent().getIntExtra("clickedSimpleCrousId", 0));
                    break;
                case "CrousProductAvaiabilityFragment" :
                    fragmentClass = CrousProductAvaiabilityFragment.newInstance(getIntent().getIntExtra("clickedSimpleCrousId", 0));
                    break;
                case "CrousMenuFragment" :
                    fragmentClass = CrousMenuFragment.newInstance();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + nextFragment);
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragmentClass)
                    .commitNow();
        }
    }
}