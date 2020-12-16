package miage.parisnanterre.fr.mynanterre2.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.Responsable;

public class RecyclerBiblioContactAdapter extends RecyclerView.Adapter<RecyclerBiblioContactAdapter.ViewHolderBiblio> {

    private Library clickedLibrary;
    List<Responsable> listResponsable;
    public RecyclerBiblioContactAdapter(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
        this.listResponsable = clickedLibrary.getResponsables();
    }
    private static final String TAG = "RecyclerAdapterBiblio";
    private int responsableIndex = 0;

    @NonNull
    @Override
    public ViewHolderBiblio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_biblio_contact, parent, false);
        ViewHolderBiblio viewHolderBiblio = new ViewHolderBiblio(view);

        return viewHolderBiblio;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolderBiblio holder, int position) {
        Responsable r = listResponsable.get(position);
            holder.textViewBiblio.setText(r.getFullName());
            holder.rowCountTextViewBiblio1.setText(!StringUtils.isEmpty(r.getMail()) ? r.getMail():"Non renseigné");
            holder.rowCountTextViewBiblio2.setText(!StringUtils.isEmpty(r.getPhoneNumber()) ? r.getPhoneNumber():"Non renseigné");
    }

    @Override
    public int getItemCount() {
        return clickedLibrary.getResponsables().size();
    }

    class ViewHolderBiblio extends RecyclerView.ViewHolder{

        ImageView imageViewBiblio;
        TextView textViewBiblio, rowCountTextViewBiblio1, rowCountTextViewBiblio2;
        public ViewHolderBiblio(@NonNull View itemView) {
            super(itemView);

            imageViewBiblio = itemView.findViewById(R.id.imageViewBiblio);
            textViewBiblio = itemView.findViewById(R.id.textViewBiblio);
            rowCountTextViewBiblio1 = itemView.findViewById(R.id.rowCountTextViewBiblio1);
            rowCountTextViewBiblio2 = itemView.findViewById(R.id.rowCountTextViewBiblio2);
        }
    }
}
