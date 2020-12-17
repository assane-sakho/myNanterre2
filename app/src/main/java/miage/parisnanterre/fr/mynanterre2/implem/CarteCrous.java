package miage.parisnanterre.fr.mynanterre2.implem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import miage.parisnanterre.fr.mynanterre2.R;

public class CarteCrous extends AppCompatActivity {

    ImageView retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carte_crous);

        retour = findViewById(R.id.back);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ListeCrous.class);
                startActivity(myIntent);
            }
        });
    }
}
