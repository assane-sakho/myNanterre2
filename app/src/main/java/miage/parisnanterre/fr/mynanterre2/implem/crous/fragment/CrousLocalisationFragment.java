package miage.parisnanterre.fr.mynanterre2.implem.crous.fragment;


import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.LocalisationListener;
import miage.parisnanterre.fr.mynanterre2.implem.crous.adapter.LocalisationCrousAdapter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousLocalisation extends Fragment {

    public Location current;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private CrousApiHelper crousApiHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        View v = inflater.inflate(R.layout.localisationcafetlist, container, false);

        crousApiHelper = CrousApiHelper.getInstance();


        recyclerView = v.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        LocalisationListener userPosition = new LocalisationListener(getContext());
        double latitudeUser = userPosition.getLatitude();
        double longitudeUser = userPosition.getLongitude();

        // adapter
        try {
            adapter = new LocalisationCrousAdapter(crousApiHelper.getAllSimpleCrous(), latitudeUser, longitudeUser);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);

        return v;
    }


    //generate a list of Link
    public List<LocalisationCafet> getListData() {
        System.out.println("je suis ici Latitude :  " + PositionUser.getLatitude() + "Je suis ici Longitude " + PositionUser.getLongitude());




        List<LocalisationCafet> cafets = new LinkedList<LocalisationCafet>();

        LocalisationCafet cafetTerrasse = new LocalisationCafet();

        cafetTerrasse.setImage(R.drawable.laterrasse);
        cafetTerrasse.setNom("Brasserie La Terrasse");
        cafetTerrasse.setInfo("11h - 14h30 en semaine");
        String distanceTerrasse = CalculDistance(48.9057091, 2.21298630000001, LatitudeUser, LongitudeUser);
        cafetTerrasse.setDistance("Se trouve à " + distanceTerrasse + " mètres");
        cafetTerrasse.setPlat("Spécialités asiatiques, grillades, tartes et salades");

        cafets.add(cafetTerrasse);



        return cafets;
    }

    public String CalculDistance(double latitudeCafet, double longitudeCafet, double latitudeUser, double longitudeUser ){

        Location locCafet = new Location("");
        locCafet.setLatitude(latitudeCafet);
        locCafet.setLongitude(longitudeCafet);

        Location locUser = new Location("");
        locUser.setLatitude(latitudeUser);
        locUser.setLongitude(longitudeUser);

        String distanceToReturn = String.format("%.0f", locCafet.distanceTo(locUser));

        return distanceToReturn;
    }

}