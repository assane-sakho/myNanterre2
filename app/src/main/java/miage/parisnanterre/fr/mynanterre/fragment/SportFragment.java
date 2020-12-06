package miage.parisnanterre.fr.mynanterre.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.helpers.ApiHelper;
import  miage.parisnanterre.fr.mynanterre.implem.ListeSport;

public class SportFragment extends ListFragment implements AdapterView.OnItemClickListener {
    private ApiHelper apiHelper = ApiHelper.getInstance();
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.liste_cat_sport, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            List<String> sports = apiHelper.getCategorieSport();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, sports);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Create intent
        id = (int) id + 1;
        Intent intent = new Intent(view.getContext(), ListeSport.class);
        Bundle extras = new Bundle();
        extras.putString(EXTRA_MESSAGE, id + "");
        intent.putExtras(extras);
        //Start details activity
        startActivity(intent);

    }
}