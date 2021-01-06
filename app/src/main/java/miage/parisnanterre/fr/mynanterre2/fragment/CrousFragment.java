package miage.parisnanterre.fr.mynanterre2.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.ListFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.crous.adapter.CrousGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousAttendanceApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.crous.activity.CrousActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousFragment extends ListFragment {

    private final int STORAGE_LOCATION_CODE = 1;
    private CrousApiHelper crousApiHelper;
    private CrousAttendanceApiHelper crousAttendanceApiHelper;
    private List<SimpleCrous> crousLoaded;
    private ProgressBar progressBar;
    private GridView gridView;
    private CrousGridAdapter adapter;
    private TextView noneCrousOpenText;

    public static CrousFragment newInstance(int v) {
        return new CrousFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.crous_list, container, false);

        super.onActivityCreated(savedInstanceState);

        crousApiHelper = CrousApiHelper.getInstance();
        crousAttendanceApiHelper = CrousAttendanceApiHelper.getInstance();

        noneCrousOpenText = v.findViewById(R.id.noneText);
        noneCrousOpenText.setVisibility(View.GONE);

        progressBar = v.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        crousLoaded = new ArrayList<>();

        GetSimpleCrousListAsync getSimpleCrousListAsync = new GetSimpleCrousListAsync();
        getSimpleCrousListAsync.execute();

        gridView = v.findViewById(R.id.gridview);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            LayoutInflater factory = LayoutInflater.from(getActivity());
            final View alertDialogView = factory.inflate(R.layout.dialog_box_frequentation, null);

            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setView(alertDialogView);

            Button btn1 = alertDialogView.findViewById(R.id.buttonfaible);
            Button btn2 = alertDialogView.findViewById(R.id.buttonmoyenne);
            Button btn3 = alertDialogView.findViewById(R.id.buttonforte);

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            btn1.setOnClickListener(v1 -> postAttendance(alertDialog, position, 1));

            btn2.setOnClickListener(v12 -> postAttendance(alertDialog, position, 2));

            btn3.setOnClickListener(v13 -> postAttendance(alertDialog, position, 3));
        });

        FloatingActionButton menuCrous = v.findViewById(R.id.MenuCrous);
        menuCrous.setOnClickListener(view -> {
            startNextCrousActivity("CrousMenuFragment");
        });

        FloatingActionButton geo = v.findViewById(R.id.Geo);
        geo.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                startNextCrousActivity("CrousLocalisationFragment");
            } else {
                requestLocationPermission();
            }
        });

        return v;
    }

    private void startNextCrousActivity(String nextFragment)
    {
        Intent myIntent = new Intent(getActivity(), CrousActivity.class);
        Bundle extras = new Bundle();
        extras.putString("nextFragment",  nextFragment);
        myIntent.putExtras(extras);
        getContext().startActivity(myIntent);
    }

    private void postAttendance(AlertDialog alertDialog, int position, int p) {
        SimpleCrous clickedSimpleCrous = crousLoaded.get(position);

        PostAttendanceAsync postAttendanceAsync = new PostAttendanceAsync(clickedSimpleCrous, p);
        postAttendanceAsync.execute();
        Toast.makeText(getActivity(), "c'est noté!", Toast.LENGTH_SHORT).show();

        alertDialog.hide();

        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);
    }

    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)) {

            new AlertDialog.Builder(getContext())
                    .setTitle("Permission nécessaire")
                    .setMessage("Nous avons besoin de votre localisation pour afficher les cafétérias proche de chez vous")
                    .setPositiveButton("ok", (dialog, which) -> ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_LOCATION_CODE))
                    .setNegativeButton("cancel", (dialog, which) -> dialog.dismiss())
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, STORAGE_LOCATION_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_LOCATION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "Permission GRANTED", Toast.LENGTH_SHORT).show();
                startNextCrousActivity("CrousLocalisationFragment");
            } else {
                Toast.makeText(getContext(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private final class GetSimpleCrousListAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                List<SimpleCrous> simpleCrousOpenList = crousApiHelper.getAllSimpleCrous()
                        .stream()
                        .filter(simpleCrous -> simpleCrous.isOpen())
                        .collect(Collectors.toList());
                crousLoaded.addAll(simpleCrousOpenList);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                if (crousLoaded.size() == 0)
                    noneCrousOpenText.setVisibility(View.VISIBLE);

                progressBar.setVisibility(View.GONE);
                adapter = new CrousGridAdapter(getContext(), crousLoaded);
                gridView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }

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
