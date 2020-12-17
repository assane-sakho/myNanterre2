package miage.parisnanterre.fr.mynanterre2.implem.library;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerBuAdapter;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;

public class ListeEspacesBu extends AppCompatActivity {

    private LibraryApiHelper libraryApiHelper;
    private List<SimpleLibrary> simpleLibraries;
    TextView title;

    private RecyclerView rvBu;
    private RecyclerBuAdapter rca;

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_espaces_bu);

        libraryApiHelper = LibraryApiHelper.getInstance();
        GetBuAsync getLibrariesAsync = new GetBuAsync();
        getLibrariesAsync.execute();

        title = findViewById(R.id.Title);
        title.setText("Listes des bibliothèques");

        //Retour vers la carte des bibliothèques.
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BiblioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.action_search);

        final androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rca.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private final class GetBuAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            simpleLibraries = libraryApiHelper.getSimpleLibraries();
            return "executed";
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(String result) {
            rvBu = findViewById(R.id.recyclerViewBu);
            rca = new RecyclerBuAdapter(simpleLibraries,ListeEspacesBu.this);

            rvBu.setAdapter(rca);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(ListeEspacesBu.this, DividerItemDecoration.VERTICAL);
            rvBu.addItemDecoration(dividerItemDecoration);
        }

    }

}
