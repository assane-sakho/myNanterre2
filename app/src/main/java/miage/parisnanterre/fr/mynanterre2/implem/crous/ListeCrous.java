package miage.parisnanterre.fr.mynanterre2.implem.crous;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.CrousGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousAttendanceApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.Accueil;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ListeCrous extends AppCompatActivity {

    private final int STORAGE_LOCATION_CODE = 1;
    private CrousApiHelper crousApiHelper;
    private CrousAttendanceApiHelper crousAttendanceApiHelper;
    private List<SimpleCrous> crousLoaded;
    //    private ProgressBar progressBar;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_crous);

        crousApiHelper = CrousApiHelper.getInstance();
        crousAttendanceApiHelper = CrousAttendanceApiHelper.getInstance();

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Accueil.class)));

        gridView = findViewById(R.id.gridview);

//        progressBar = findViewById(R.id.progress);
        crousLoaded = new ArrayList<>();

        GetCrousAsync getCrousAsync = new GetCrousAsync();
        getCrousAsync.execute();

        gridView.setOnItemClickListener((parent, v, position, id) -> {
            Object o = gridView.getItemAtPosition(position);

            //On instancie notre layout en tant que View
            LayoutInflater factory = LayoutInflater.from(ListeCrous.this);
            final View alertDialogView = factory.inflate(R.layout.dialog_box_frequentation, null);

            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(ListeCrous.this);
            alertDialogBuilder.setView(alertDialogView);

            Button btn1 = alertDialogView.findViewById(R.id.buttonfaible);
            Button btn2 = alertDialogView.findViewById(R.id.buttonmoyenne);
            Button btn3 = alertDialogView.findViewById(R.id.buttonforte);

            btn1.setOnClickListener(v1 -> {
                PostAttendance(position, 1);
            });

            btn2.setOnClickListener(v12 -> {
                PostAttendance(position, 2);
            });

            btn3.setOnClickListener(v13 -> {
                PostAttendance(position, 3);
            });

            alertDialogBuilder.create().show();
        });

        FloatingActionButton menuCrous = findViewById(R.id.MenuCrous);
        menuCrous.setOnClickListener(view -> {
            Intent myIntent = new Intent(getApplicationContext(), CarteCrous.class);
            Bundle extras = new Bundle();
            myIntent.putExtras(extras);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(myIntent);

        });

        FloatingActionButton geo = findViewById(R.id.Geo);
        geo.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                Intent myIntent = new Intent(getApplicationContext(), LocalisationCrousMain.class);
                Bundle extras = new Bundle();
                myIntent.putExtras(extras);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(myIntent);
            } else {
                requestLocationPermission();
            }
        });
    }

    private void PostAttendance(int position, int p) {
        SimpleCrous clickedSimpleCrous = crousLoaded.get(position);

        PostAttendanceAsync postAttendanceAsync = new PostAttendanceAsync(clickedSimpleCrous, 3);
        postAttendanceAsync.execute();
        Toast.makeText(getApplicationContext(), "c'est noté!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ListeCrous.this, ListeCrous.class));
    }

    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission nécessaire")
                    .setMessage("Nous avons besoin de votre localisation pour afficher les cafétérias proche de chez vous")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(ListeCrous.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_LOCATION_CODE);
                        }

                    })
                    .setNegativeButton("cancel", (dialog, which) -> dialog.dismiss())
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_LOCATION_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_LOCATION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(getApplicationContext(), LocalisationCrousMain.class);
                Bundle extras = new Bundle();
                myIntent.putExtras(extras);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(myIntent);

            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private final class GetCrousAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                crousLoaded.addAll(crousApiHelper.getAllSimpleCrous());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
//            progressBar.setVisibility(View.GONE);

            gridView.setAdapter(new CrousGridAdapter(getApplicationContext(), crousLoaded));
        }

    }

    private final class PostAttendanceAsync extends AsyncTask<Void, Void, String> {

        private SimpleCrous clickedSimpleCrous;
        private int p;

        public PostAttendanceAsync(SimpleCrous clickedSimpleCrous, int p) {
            this.clickedSimpleCrous = clickedSimpleCrous;
            this.p = p;
        }

        @Override
        protected String doInBackground(Void... params) {
            switch (p) {
                case 1:
                    try {
                        crousAttendanceApiHelper.createLowAttendance(clickedSimpleCrous);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        crousAttendanceApiHelper.createMediumAttendance(clickedSimpleCrous);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        crousAttendanceApiHelper.createHighAttendance(clickedSimpleCrous);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            return "executed";
        }
    }
}