package miage.parisnanterre.fr.mynanterre2.adapter;

import android.content.Context;
import android.content.Intent;
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

import org.apache.commons.lang3.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.Responsable;
import miage.parisnanterre.fr.mynanterre2.implem.club.ClubInfoActivity;
import miage.parisnanterre.fr.mynanterre2.implem.library.LibraryDesc;

public class RecyclerBuAdapter extends RecyclerView.Adapter<RecyclerBuAdapter.ViewHolderBu> implements Filterable {

    private List<Library> libraries;
    private List<Library> librariesAll;
    Context context;

    public RecyclerBuAdapter(List<Library> libraries, Context context)
    {
        this.context = context;
        this.libraries = libraries;
        this.librariesAll = libraries;
    }

    @NonNull
    @Override
    public ViewHolderBu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_bu, parent, false);
        ViewHolderBu viewHolderBu = new ViewHolderBu(view);

        return viewHolderBu;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolderBu holder, int position) {
            holder.textViewBu.setText(libraries.get(position).getName());
            holder.rowCountTextViewBu.setText(String.valueOf(position));

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), libraries.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), LibraryDesc.class);
                intent.putExtra("clickedLibraryIndex", libraries.get(position).getId());
                //Start details activity

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return libraries.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Library> filteredList = new ArrayList<>();

            if(charSequence.toString().isEmpty()){
                filteredList.addAll(librariesAll);
            }else{
                for(Library lib: librariesAll){
                    if(lib.getName().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(lib);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            libraries.clear();
            libraries.addAll((Collection<Library>)filterResults.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolderBu extends RecyclerView.ViewHolder{

        ImageView imageViewBu;
        TextView textViewBu, rowCountTextViewBu;
        public ViewHolderBu(@NonNull View itemView) {
            super(itemView);

            imageViewBu = itemView.findViewById(R.id.imageViewBu);
            textViewBu = itemView.findViewById(R.id.textViewBu);
            rowCountTextViewBu = itemView.findViewById(R.id.rowCountTextViewBu);

        }
    }
}
