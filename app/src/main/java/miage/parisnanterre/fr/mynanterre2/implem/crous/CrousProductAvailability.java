package miage.parisnanterre.fr.mynanterre2.implem.crous;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.ProduitGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;


public class CrousProductAvailability extends AppCompatActivity {

    private CrousApiHelper crousApiHelper;
    private Crous clickedCrous;
    private int clickedSimpleCrousId;
    private GridView gridView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_produit);

        crousApiHelper = CrousApiHelper.getInstance();

        Bundle extras = getIntent().getExtras();
        clickedSimpleCrousId = extras.getInt("clickedSimpleCrousId");

        GetCrousAsync getCrousAsync = new GetCrousAsync();
        getCrousAsync.execute();

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ListeCrous.class)));

        gridView = findViewById(R.id.gridview);

        LayoutInflater factory = LayoutInflater.from(CrousProductAvailability.this);
        final View alertDialogView = factory.inflate(R.layout.dialog_box_dispo, null);

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(CrousProductAvailability.this);
        alertDialogBuilder.setView(alertDialogView);

        Button btnOK = alertDialogView.findViewById(R.id.buttonok);
        Button btnKO = alertDialogView.findViewById(R.id.buttonko);

        gridView.setOnItemClickListener((parent1, v13, position1, id1) -> {
            LayoutInflater factory1 = LayoutInflater.from(CrousProductAvailability.this);
            final View alertDialogView1 = factory1.inflate(R.layout.dialog_box_dispo, null);
            AlertDialog.Builder alertDialogBuilder1;
            alertDialogBuilder1 = new AlertDialog.Builder(CrousProductAvailability.this);
            alertDialogBuilder1.setView(alertDialogView1);

            btnOK.setOnClickListener(v1 -> {
                PostAvailability(position1, true);
            });

            btnKO.setOnClickListener(v2 -> {
                PostAvailability(position1, false);
            });

            alertDialogBuilder1.create().show();
        });
    }


    private void PostAvailability(int position, boolean isAvailable) {
        CrousProduct crousProduct = clickedCrous.getCrousProducts().get(position);
        PostAvailabilityAsync postAvailabilityAsync = new PostAvailabilityAsync(crousProduct, isAvailable);
        postAvailabilityAsync.execute();
        Toast.makeText(getApplicationContext(), "c'est noté!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CrousProductAvailability.this, ListeCrous.class));
    }


    private final class GetCrousAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            clickedCrous = crousApiHelper.getCrous(clickedSimpleCrousId);
            return "executed";
        }
        @Override
        protected void onPostExecute(String result) {
            gridView.setAdapter(new ProduitGridAdapter(getApplicationContext(), clickedCrous));
        }
    }

    private final class PostAvailabilityAsync extends AsyncTask<Void, Void, String> {

        private CrousProduct clickedCrousProduct;
        private boolean isAvailable;

        public PostAvailabilityAsync(CrousProduct clickedSimpleCrous, boolean isAvailable) {
            this.clickedCrousProduct = clickedSimpleCrous;
            this.isAvailable = isAvailable;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            //clickedCrous = crousApiHelper.getCrous(clickedSimpleCrousId);
            return "executed";
        }
    }

}