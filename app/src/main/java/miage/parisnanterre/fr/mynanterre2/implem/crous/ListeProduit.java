package miage.parisnanterre.fr.mynanterre2.implem.crous;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.CrousGridAdapter;
import miage.parisnanterre.fr.mynanterre2.adapter.ProduitGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.library.LibraryDesc;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;


public class ListeProduit extends AppCompatActivity {

    int burger;
    private CrousApiHelper crousApiHelper;
    private Crous clickedCrous;
    private int clickedSimpleCrousId;

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

        final GridView gridView = findViewById(R.id.gridview);

        gridView.setOnItemClickListener((parent, v, position, id) -> {
            LayoutInflater factory = LayoutInflater.from(ListeProduit.this);
            final View alertDialogView = factory.inflate(R.layout.dialog_box_dispo, null);

            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(ListeProduit.this);
            alertDialogBuilder.setView(alertDialogView);

            Button btnOK = alertDialogView.findViewById(R.id.buttonok);
            Button btnKO = alertDialogView.findViewById(R.id.buttonko);


            gridView.setOnItemClickListener((parent1, v13, position1, id1) -> {
                LayoutInflater factory1 = LayoutInflater.from(ListeProduit.this);
                final View alertDialogView1 = factory1.inflate(R.layout.dialog_box_dispo, null);
                AlertDialog.Builder alertDialogBuilder1;
                alertDialogBuilder1 = new AlertDialog.Builder(ListeProduit.this);
                alertDialogBuilder1.setView(alertDialogView1);

                btnOK.setOnClickListener(v1 -> {
                    PostAvailability(position1, true);
                });

                btnKO.setOnClickListener(v12 -> {
                    PostAvailability(position1, false);
                });

                alertDialogBuilder1.create().show();
            });
        });
    }


    private void PostAvailability(int position, boolean isAvailable) {
        CrousProduct crousProduct = clickedCrous.getCrousProducts().get(position);
        PostAvailabilityAsync postAvailabilityAsync = new PostAvailabilityAsync(crousProduct, isAvailable);
        postAvailabilityAsync.execute();
        Toast.makeText(getApplicationContext(), "c'est noté!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ListeProduit.this, ListeCrous.class));
    }


    private final class GetCrousAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            clickedCrous = crousApiHelper.getCrous(clickedSimpleCrousId);
            return "executed";
        }
    }

    private final class PostAvailabilityAsync extends AsyncTask<Void, Void, String> {

        private CrousProduct clickedCrousProduct;
        private boolean isAvailable;

        public PostAvailabilityAsync(CrousProduct clickedSimpleCrous, boolean isAvailable) {
            this.clickedCrousProduct = clickedSimpleCrous;
            this.isAvailable = isAvailable;
        }

        @Override
        protected String doInBackground(Void... params) {
            return "executed";
        }
    }

}