package miage.parisnanterre.fr.mynanterre2.implem.club;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubInfoFragment;

public class ClubInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_info_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ClubInfoFragment.newInstance())
                    .commitNow();
        }
    }
}