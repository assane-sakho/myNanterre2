package miage.parisnanterre.fr.mynanterre2.implem.crous.fragment;

import android.Manifest;
import android.content.DialogInterface;
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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.CrousGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousAttendanceApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubInfoFragment;
import miage.parisnanterre.fr.mynanterre2.implem.crous.CarteCrous;
import miage.parisnanterre.fr.mynanterre2.implem.crous.LocalisationCrousMain;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousAttendanceFragment extends ListFragment {

    BarChart barChart;
    private CrousApiHelper crousApiHelper;
    private SimpleCrous clickedSimpleCrous;

    public CrousAttendanceFragment(int clickedSimpleCrousId){
        crousApiHelper = CrousApiHelper.getInstance();
        clickedSimpleCrous = crousApiHelper.getSimpleCrous(clickedSimpleCrousId);
    }

    public static CrousAttendanceFragment newInstance(int clickedSimpleCrousId) {
        return new CrousAttendanceFragment(clickedSimpleCrousId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.chart_frequentation_cafet, container, false);

        super.onActivityCreated(savedInstanceState);

        List<BarEntry> barEntries = new ArrayList<>();
        clickedSimpleCrous.getCrousAttendances().forEach(attendance->{
            int xValues = attendance.getHour();
            int yValues = attendance.getProportion();
            //ajout au graphique ses données
            barEntries.add(new BarEntry(xValues, yValues));
        });

        TextView txtview = v.findViewById(R.id.nomBatiment);
        txtview.setText(clickedSimpleCrous.getName() + " : " + clickedSimpleCrous.getLocation());

        barChart = v.findViewById(R.id.barchart);

        //Config
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(100);
        barChart.setPinchZoom(false);
        barChart.setVisibility(View.VISIBLE);
        barChart.setDrawGridBackground(true);
        barChart.animateY(3000);

        Description description = new Description();
        description.setText("heure (abscisse), proportion % (ordonnée)");
        barChart.setDescription(description);

        BarDataSet barDataSet = new BarDataSet(barEntries, "Affluence en %");

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(1f);

        barChart.setData(barData);
        barChart.invalidate();
        return v;
    }


}
