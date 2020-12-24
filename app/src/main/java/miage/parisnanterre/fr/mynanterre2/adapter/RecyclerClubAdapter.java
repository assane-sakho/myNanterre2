package miage.parisnanterre.fr.mynanterre2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.club.ClubInfoActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class RecyclerClubAdapter extends RecyclerView.Adapter<RecyclerClubAdapter.ViewHolder> implements Filterable {

    ClubApiHelper clubApiHelper;
    List<SimpleClub> clubList;
    List<SimpleClub> finalClubList;
    Context context;

    public RecyclerClubAdapter(Context context, List<SimpleClub> clubList) {
        this.context = context;
        this.clubApiHelper = ClubApiHelper.getInstance();
        finalClubList = clubList;
        this.clubList = finalClubList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutI = LayoutInflater.from(parent.getContext());
        View view = layoutI.inflate(R.layout.row_item_club, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleClub clubClicked = clubList.get(position);

        holder.textViewNomClub.setText(clubClicked.getName());
        holder.textViewCatClub.setText(clubClicked.getType().getName());
        Bitmap bitmap = BitmapFactory.decodeByteArray(clubClicked.getImageBytes(), 0,clubClicked.getImageBytes().length);

        holder.imageViewClub.setImageBitmap(bitmap);

        if (!clubClicked.isCertificate()) {
            holder.certif.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), clubList.get(position).getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, ClubInfoActivity.class);
            intent.putExtra("simpleClubId",clubClicked.getId());

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<SimpleClub> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList = finalClubList;
            } else {
                for (SimpleClub club : finalClubList) {
                    if (club.getName().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                            club.getType().getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
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
            clubList = (List<SimpleClub>) filterResults.values;
            notifyDataSetChanged();
        }

    };

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewClub;
        ImageView certif;
        TextView textViewNomClub;
        TextView textViewCatClub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewClub = itemView.findViewById(R.id.imageViewClub);
            textViewNomClub = itemView.findViewById(R.id.textViewNomClub);
            textViewCatClub = itemView.findViewById(R.id.textViewCatClub);
            certif = itemView.findViewById(R.id.certif);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), clubList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }

}
