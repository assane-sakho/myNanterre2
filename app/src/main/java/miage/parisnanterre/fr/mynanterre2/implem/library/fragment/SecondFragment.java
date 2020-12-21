package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;

public class SecondFragment extends Fragment {

    Intent intent;
    BarChart barChart;
    View v;

    public SecondFragment() {
// Required empty public constructor
    }

    public SecondFragment(Intent intent) {
        this.intent = intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_second, container, false);



        LibraryApiHelper libraryApiHelper = LibraryApiHelper.getInstance();
        try {
            List<SimpleLibrary> libraries = libraryApiHelper.getAllSimpleLibraries();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<BarEntry> barEntries = new ArrayList<>();

        Intent myIntent = getIntent(); // gets the previously created intent

        //Insertion des données
        try {
            int clickedLibraryIndex = myIntent.getIntExtra("clickedLibraryIndex", 0);
            Library clickedLibrary = libraryApiHelper.getLibrary(clickedLibraryIndex);

            int xValues;
            int yValues;

            for(Attendance attendance : clickedLibrary.getAttendances())
            {
                xValues = attendance.getHour();
                yValues = attendance.getProportion();

                barEntries.add(new BarEntry(xValues,yValues));
            }

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

            BarDataSet barDataSet =new BarDataSet(barEntries, "Affluence en %");

            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            BarData barData = new BarData(barDataSet);
            barData.setBarWidth(1f);

            barChart.setData(barData);
            barChart.invalidate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return v;
    }

    private Intent getIntent() {
        return this.intent;
    }

}