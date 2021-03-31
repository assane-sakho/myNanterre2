package miage.parisnanterre.fr.mynanterre2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserClubApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class RecyclerActuAdapter extends RecyclerView.Adapter<RecyclerActuAdapter.ViewHolder> {

    List<Publication> publicationsList;
    Context context;

    /**
     * Le constructeur qui initialise les variables
     */


    public RecyclerActuAdapter(Context context, List<Publication> publicationsList) {
        this.context = context;
        this.publicationsList = publicationsList;
    }

    /**
     * on créée la view
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutI = LayoutInflater.from(parent.getContext());
        View view = layoutI.inflate(R.layout.row_item_actu, parent, false);

        return new ViewHolder(view);
    }

    /**
     * On remplis chaque view avec leurs données
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Publication publication = publicationsList.get(position);

        holder.tv_nomClub.setText(publication.getClub().getName());
        holder.tv_heure.setText(publication.getDate().getDayOfMonth()+" "+publication.getDate().getMonth().toString()+" "+publication.getDate().getYear());
        holder.tv_desc.setText(publication.getMessage());
        Bitmap bitmap = BitmapFactory.decodeByteArray(publication.getClub().getImageBytes(), 0,publication.getClub().getImageBytes().length);

        holder.imgView_clubPic.setImageBitmap(bitmap);
    }

    /**
     * le nombre d'item du recycler view
     */

    @Override
    public int getItemCount() {
        return publicationsList.size();
    }


    /**
     * class du view d'une publication dans le recyclerview
     */

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView_clubPic;
        ImageView imgView_postPic;
        TextView tv_nomClub;
        TextView tv_heure;
        TextView tv_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView_clubPic = itemView.findViewById(R.id.imgView_clubPic);
            imgView_postPic = itemView.findViewById(R.id.imgView_postPic);
            tv_nomClub = itemView.findViewById(R.id.tv_nomClub);
            tv_heure = itemView.findViewById(R.id.tv_heure);
            tv_desc = itemView.findViewById(R.id.tv_desc);

        }

    }

}
