package miage.parisnanterre.fr.mynanterre2.implem.crous.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousLocalisationAdapter extends RecyclerView.Adapter<CrousLocalisationAdapter.MyViewHolder> {

    private List<SimpleCrous> simpleCrousList;
    private final Location locUser;
    private final int rgbRed;
    private final int rgbGreen;

    // constructor
    public CrousLocalisationAdapter(List<SimpleCrous> simpleCrousList, double latitudeUser, double longitudeUser) {
        this.simpleCrousList = simpleCrousList;

        locUser = new Location("");
        locUser.setLatitude(latitudeUser);
        locUser.setLongitude(longitudeUser);

        rgbRed = Color.rgb(200,0,0);
        rgbGreen = Color.rgb(0,200,0);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflate item_layout
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crous_localisation_item, null);

        return new MyViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SimpleCrous simpleCrous = simpleCrousList.get(position);
        Bitmap bitmap = BitmapFactory.decodeByteArray(simpleCrous.getImage(), 0, simpleCrous.getImage().length);
        holder.image.setImageBitmap(bitmap);
        holder.nom.setText(simpleCrous.getName());
        holder.distance.setText("Se trouve à " + CalculDistance(simpleCrous) + " mètres");
        holder.info.setText(simpleCrous.getLocation());
        holder.plat.setText(simpleCrous.getProductsNameConcat());

        if(simpleCrous.isOpen())
        {
            holder.txtViewIsOpen.setText("Ouvert");
            holder.txtViewIsOpen.setTextColor(rgbGreen);
        }
        else
        {
            holder.txtViewIsOpen.setText("Fermé");
            holder.txtViewIsOpen.setTextColor( rgbRed);
        }
    }

    @Override
    public int getItemCount() {
        return simpleCrousList.size();
    }

    // inner static class
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView nom;
        public TextView distance;
        public TextView info;
        public TextView plat;
        public TextView txtViewIsOpen;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            image = itemLayoutView.findViewById(R.id.imageCafet);
            nom = itemLayoutView.findViewById(R.id.NomCafet);
            distance = itemLayoutView.findViewById(R.id.DistanceCafet);
            info = itemLayoutView.findViewById(R.id.infoCafet);
            plat = itemLayoutView.findViewById(R.id.plat);
            txtViewIsOpen = itemLayoutView.findViewById(R.id.txtViewIsOpen);
        }
    }

    public String CalculDistance(SimpleCrous simpleCrous) {

        Location locCafet = new Location("");
        locCafet.setLatitude(simpleCrous.getLatitude());
        locCafet.setLongitude(simpleCrous.getLongitude());

        String distanceToReturn = String.format("%.0f", locCafet.distanceTo(locUser));

        return distanceToReturn;
    }

}
