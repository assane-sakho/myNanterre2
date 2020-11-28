package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.api.library.Library;
import miage.parisnanterre.fr.mynanterre.helpers.api.LibraryApiHelper;

public class ListeEspacesBu extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";

    private LibraryApiHelper libraryApiHelper;
    private List<Library> libraries;
    private List<String> librariesName;

    private ListView m_listview;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_espaces_bu);

        libraryApiHelper = LibraryApiHelper.getInstance();

        try {
            libraries = libraryApiHelper.getLibraries();
            librariesName = libraries.stream().map(Library::getName).collect(Collectors.toList());;
            m_listview = findViewById(R.id.list_view);

            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, librariesName);

            m_listview.setAdapter(adapter);
            m_listview.setOnItemClickListener(this);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Une erreur est survenue.", Toast.LENGTH_SHORT).show();
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
           

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Une erreur est survenue.", Toast.LENGTH_SHORT).show();
        }

        //Create intent
        id = (int) id + 1;
        Intent intent = new Intent(view.getContext(), FrequentationBu.class);
        Bundle extras = new Bundle();
        extras.putString(EXTRA_MESSAGE, id + ""); //get id
        extras.putString(EXTRA_MESSAGE2, String.valueOf(this.m_listview.getItemAtPosition(position).toString())); //get nom espace bu
        intent.putExtras(extras);
        //Start details activity
        startActivity(intent);
    }
}
