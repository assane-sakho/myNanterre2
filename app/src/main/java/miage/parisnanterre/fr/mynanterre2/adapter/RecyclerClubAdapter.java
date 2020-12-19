package miage.parisnanterre.fr.mynanterre2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.club.ClubInfoActivity;

public class RecyclerClubAdapter extends RecyclerView.Adapter<RecyclerClubAdapter.ViewHolder> implements Filterable {

    ClubApiHelper clubApiHelper;
    List<SimpleClub> clubList;
    List<SimpleClub> clubListAll;
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public RecyclerClubAdapter(Context context) throws ExecutionException, InterruptedException {
        this.context = context;
        this.clubApiHelper = ClubApiHelper.getInstance();
        clubList = new ArrayList<>(clubApiHelper.getSimpleClubs());
        clubListAll = new ArrayList<>(clubList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater LayoutI = LayoutInflater.from(parent.getContext());
        View view = LayoutI.inflate(R.layout.row_item_club, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewNomClub.setText(clubList.get(position).getName());
        holder.textViewCatClub.setText(clubList.get(position).getType().getName());
        Bitmap bitmap = BitmapFactory.decodeByteArray(clubList.get(position).getImage(), 0, clubList.get(position).getImage().length);
        holder.imageViewClub.setImageBitmap(bitmap);

        if (clubList.get(position).isCertificate() == false) {
            holder.certif.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SimpleClub clubClicked = clubList.get(position);

                Toast.makeText(view.getContext(), clubList.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ClubInfoActivity.class);
                intent.putExtra("image", clubList.get(position).getImage());
                intent.putExtra("nom", clubList.get(position).getName());
                intent.putExtra("cat", clubList.get(position).getType().getName());
                intent.putExtra("creator", clubList.get(position).getCreator().getFirstName() + " " + clubList.get(position).getCreator().getLastName());
                intent.putExtra("desc", clubList.get(position).getDescription());
                intent.putExtra("date", clubList.get(position).getCreationDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
                intent.putExtra("certified", clubList.get(position).isCertificate());

                context.startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int getItemCount() {
        return clubList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<SimpleClub> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(clubListAll);
            } else {
                for (SimpleClub club : clubListAll) {
                    if (club.getName().toLowerCase().contains(charSequence.toString().toLowerCase()) || club.getType().getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(club);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            clubList.clear();
            clubList.addAll((Collection<Club>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewClub, certif;
        TextView textViewNomClub, textViewCatClub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewClub = itemView.findViewById(R.id.imageViewClub);
            textViewNomClub = itemView.findViewById(R.id.textViewNomClub);
            textViewCatClub = itemView.findViewById(R.id.textViewCatClub);
            certif = itemView.findViewById(R.id.certif);

            itemView.setOnClickListener(this);

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), clubList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }

}
