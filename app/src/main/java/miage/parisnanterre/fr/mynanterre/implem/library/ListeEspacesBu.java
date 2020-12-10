package miage.parisnanterre.fr.mynanterre.implem.library;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.api.library.Library;
import miage.parisnanterre.fr.mynanterre.fragment.BiblioFragment;
import miage.parisnanterre.fr.mynanterre.helpers.api.LibraryApiHelper;

public class ListeEspacesBu extends AppCompatActivity implements AdapterView.OnItemClickListener {

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


            //Retour vers la carte des ibliothèques.
            ImageView back = findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), BiblioFragment.class));
                }
            });

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Une erreur est survenue.", Toast.LENGTH_SHORT).show();
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), LibraryDesc.class);
        intent.putExtra("clickedLibraryIndex", position);

        //Start details activity
        startActivity(intent);
    }
}
