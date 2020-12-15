package miage.parisnanterre.fr.mynanterre2.implem.library;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;


public class LibraryInfo extends AppCompatActivity {

    BarChart barChart;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_frequentation_bu);

        LibraryApiHelper libraryApiHelper = LibraryApiHelper.getInstance();
        List<Library> libraries = libraryApiHelper.getLibraries();

        List<BarEntry> barEntries = new ArrayList<>();

        Intent myIntent = getIntent(); // gets the previously created intent

        //Insertion des données
        try {
            int clickedLibraryIndex = myIntent.getIntExtra("clickedLibraryIndex", 0);
            Library clickedLibrary = libraries.get(clickedLibraryIndex);

            int xValues;
            int yValues;

            for(Attendance attendance : clickedLibrary.getAttendances())
            {
                xValues = attendance.getHour();
                yValues = attendance.getProportion();

                barEntries.add(new BarEntry(xValues,yValues));
            }

            TextView txtview = findViewById(R.id.nomEspace);
            txtview.setText(clickedLibrary.getName());

            barChart = findViewById(R.id.barchart);

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

    }

}