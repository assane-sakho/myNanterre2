package miage.parisnanterre.fr.mynanterre2.implem.club;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import miage.parisnanterre.fr.mynanterre2.fragment.ClubFragment;
import miage.parisnanterre.fr.mynanterre2.R;

public class ClubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ClubFragment.newInstance())
                    .commitNow();
        }
    }
}