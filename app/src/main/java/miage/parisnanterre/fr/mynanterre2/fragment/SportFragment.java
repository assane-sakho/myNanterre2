package miage.parisnanterre.fr.mynanterre2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.ListFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.helpers.ApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.ListeSport;

/**
 * Created by Sankar Vijay on 26/01/2019.
 */
public class SportFragment extends ListFragment implements AdapterView.OnItemClickListener {
    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private List<String> sports = new ArrayList<>();
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.liste_cat_sport, container, false);

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception e) {
//            Toast.makeText(getContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
//        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       /* try {
            ApiHelper apiHelper = new ApiHelper();
            String jsonResult = apiHelper.get("https://mynanterreapi.herokuapp.com/index.php/api/getCategorieSport");
            JSONArray jsonArray = new JSONArray(jsonResult);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject j = new JSONObject(jsonArray.getString(i));
                sports.add(j.getString("categorie"));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, sports);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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