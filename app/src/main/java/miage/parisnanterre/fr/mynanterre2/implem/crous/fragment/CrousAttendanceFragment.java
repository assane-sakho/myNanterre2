package miage.parisnanterre.fr.mynanterre2.implem.crous.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousAttendanceFragment extends Fragment {

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

        super.onActivityCreated(savedInstanceState);

        View v = inflater.inflate(R.layout.crous_attendance, container, false);

        TextView title = v.findViewById(R.id.Title);
        title.setText("Fréquentation du crous " + clickedSimpleCrous.getName());
        title.setTextSize(15);

        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(x -> getActivity().onBackPressed());

        List<BarEntry> barEntries = new ArrayList<>();
        clickedSimpleCrous.getCrousAttendances().forEach(attendance->{
            int xValues = attendance.getHour();
            int yValues = attendance.getProportion();
            //ajout au graphique ses données
            barEntries.add(new BarEntry(xValues, yValues));
        });

        TextView txtview = v.findViewById(R.id.nomBatiment);
        txtview.setText(clickedSimpleCrous.getLocation());

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
