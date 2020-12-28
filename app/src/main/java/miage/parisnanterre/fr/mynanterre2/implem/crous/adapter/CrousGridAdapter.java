package miage.parisnanterre.fr.mynanterre2.implem.crous.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.crous.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.implem.crous.activity.CrousActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousGridAdapter extends BaseAdapter{

    private List<SimpleCrous> crousList;
    private LayoutInflater layoutInflater;
    private Context context;

    public CrousGridAdapter(Context aContext, List<SimpleCrous> crousList) {
        this.context = aContext;
        this.crousList = crousList;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return crousList.size();
    }

    @Override
    public Object getItem(int position) {
        return crousList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CrousGridAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_batiment, null);
            holder = new CrousGridAdapter.ViewHolder();
            holder.batiment = convertView.findViewById(R.id.batiment);
            holder.lieu = convertView.findViewById(R.id.lieu);
            holder.sandwich = convertView.findViewById(R.id.buttonSand);
            holder.chart = convertView.findViewById(R.id.buttonChartFreq);
            convertView.setTag(holder);
        } else {
            holder = (CrousGridAdapter.ViewHolder) convertView.getTag();
        }

        SimpleCrous simpleCrous = this.crousList.get(position);
        holder.batiment.setText(simpleCrous.getLocation());
        holder.lieu.setText(simpleCrous.getName());

        Collections.reverse(simpleCrous.getCrousAttendances());
        Optional<Attendance> lastAttendance = simpleCrous.getCrousAttendances().stream().findFirst();
        if (lastAttendance.isPresent() && lastAttendance.get().getProportion() == 100) {
            convertView.setBackgroundColor(Color.rgb(191, 10, 1));
        } else if (lastAttendance.isPresent() && lastAttendance.get().getProportion() == 60) {
            convertView.setBackgroundColor(Color.rgb(242, 178, 55));
        } else {
            convertView.setBackgroundColor(Color.rgb(147, 194, 6));
        }

        holder.sandwich.setOnClickListener(v -> {
            startNextCrousActivity(simpleCrous, "CrousProductAvaiabilityFragment");
        });

        holder.chart.setOnClickListener(v -> {
            startNextCrousActivity(simpleCrous, "CrousAttendanceFragment");
        });
        return convertView;
    }

    private void startNextCrousActivity(SimpleCrous simpleCrous, String nextFragment)
    {
        Intent myIntent = new Intent(context.getApplicationContext(), CrousActivity.class);
        Bundle extras = new Bundle();

        extras.putInt("clickedSimpleCrousId", simpleCrous.getId());
        extras.putString("nextFragment",  nextFragment);

        myIntent.putExtras(extras);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);
    }

    private static class ViewHolder {
        private TextView batiment;
        private TextView lieu;
        private ImageView sandwich;
        private ImageView chart;
    }

}