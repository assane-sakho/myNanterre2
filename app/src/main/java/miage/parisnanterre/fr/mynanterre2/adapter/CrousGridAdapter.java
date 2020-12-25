package miage.parisnanterre.fr.mynanterre2.adapter;

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
import miage.parisnanterre.fr.mynanterre2.implem.FrequentationBatiment;
import miage.parisnanterre.fr.mynanterre2.implem.crous.ListeProduit;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousGridAdapter extends BaseAdapter{

    private List<SimpleCrous> crousList;
    private LayoutInflater layoutInflater;
    private Context context;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";


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
            holder.vote = convertView.findViewById(R.id.vote);
            holder.chart = convertView.findViewById(R.id.buttonChartFreq);
            convertView.setTag(holder);
        } else {
            holder = (CrousGridAdapter.ViewHolder) convertView.getTag();
        }

        SimpleCrous simpleCrous = this.crousList.get(position);
        holder.batiment.setText("1");
        holder.lieu.setText(simpleCrous.getLocation());
        holder.vote.setText("1");

        Collections.reverse(simpleCrous.getCrousAttendances());
        Optional<Attendance> lastAttendance = simpleCrous.getCrousAttendances().stream().findFirst();
        if (lastAttendance.isPresent() && lastAttendance.get().getProportion() == 1) {
            convertView.setBackgroundColor(Color.rgb(147, 194, 6));
        } else if (lastAttendance.isPresent() && lastAttendance.get().getProportion() == 2) {
            convertView.setBackgroundColor(Color.rgb(242, 178, 55));
        } else {
            convertView.setBackgroundColor(Color.rgb(191, 10, 1));
        }

        holder.sandwich.setOnClickListener(v -> {
            Intent myIntent = new Intent(context.getApplicationContext(), ListeProduit.class);
            Bundle extras = new Bundle();
            extras.putString(EXTRA_MESSAGE, String.valueOf(""));
            myIntent.putExtras(extras);
            context.startActivity(myIntent);
        });

        holder.chart.setOnClickListener(v -> {
            Intent myIntent = new Intent(context.getApplicationContext(), FrequentationBatiment.class);
            Bundle extras = new Bundle();
            extras.putString(EXTRA_MESSAGE,String.valueOf(""));
            extras.putString(EXTRA_MESSAGE2, String.valueOf(""));
            myIntent.putExtras(extras);
            context.startActivity(myIntent);
        });
        return convertView;
    }

    private static class ViewHolder {
        private TextView batiment;
        private TextView lieu;
        private ImageView sandwich;
        private TextView vote;
        private ImageView chart;
    }

}