package miage.parisnanterre.fr.mynanterre.implem.library;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.api.library.Attendance;
import miage.parisnanterre.fr.mynanterre.api.library.Library;
import miage.parisnanterre.fr.mynanterre.api.library.Responsable;
import miage.parisnanterre.fr.mynanterre.helpers.api.LibraryApiHelper;
import miage.parisnanterre.fr.mynanterre.implem.Accueil;

public class LibraryDesc extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bu_info);

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


            //Retour vers la liste des bibliothèques.
            ImageView back = findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ListeEspacesBu.class));
                }
            });

            TextView txtview = findViewById(R.id.NameBU);
            txtview.setText(clickedLibrary.getName());

            TextView txtResponsable = findViewById(R.id.ResponsableName);
            txtResponsable.setText(clickedLibrary.getResponsables().stream().map(Responsable::getFullName).collect(Collectors.joining(", ")));



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}