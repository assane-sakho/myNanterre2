package miage.parisnanterre.fr.mynanterre2.implem.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.library.fragment.BiblioFragment;

public class BiblioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biblio_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BiblioFragment.newInstance())
                    .commitNow();
        }
    }
}