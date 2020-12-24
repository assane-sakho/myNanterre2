package miage.parisnanterre.fr.mynanterre2.implem.club;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubInfoFragment;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_info_activity);
        if (savedInstanceState == null) {
            int v = getIntent().getIntExtra("simpleClubId", 0);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ClubInfoFragment.newInstance(v))
                    .commitNow();
        }
    }
}