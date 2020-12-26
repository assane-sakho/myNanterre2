package miage.parisnanterre.fr.mynanterre2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;
import miage.parisnanterre.fr.mynanterre2.api.crous.ProductAvailability;

public class ProduitGridAdapter extends BaseAdapter {

    private List<CrousProduct> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ProduitGridAdapter(Context aContext, Crous clickedCrous) {
        this.context = aContext;
        this.listData = clickedCrous.getCrousProducts();
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProduitGridAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_produit, null);
            holder = new ProduitGridAdapter.ViewHolder();
            holder.produit = convertView.findViewById(R.id.produit);
            convertView.setTag(holder);
        } else {
            holder = (ProduitGridAdapter.ViewHolder) convertView.getTag();
        }

        CrousProduct crousProduct = this.listData.get(position);
        holder.produit.setText(crousProduct.getProduct().getName());

        LocalDate today = LocalDate.now();

        List<ProductAvailability> listAvailability = crousProduct.getProductAvailabilities().stream().filter(productAvailability -> productAvailability.getDate().toLocalDate().equals(today)).collect(Collectors.toList());

        Collections.reverse(listAvailability);

        Optional<ProductAvailability> p = listAvailability.stream().findFirst();

        if (p.isPresent() && !p.get().isAvailable()) {
            convertView.setBackgroundColor(Color.rgb(191, 10, 1));
        } else {
            convertView.setBackgroundColor(Color.rgb(147, 194, 6));

        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView produit;
    }

}