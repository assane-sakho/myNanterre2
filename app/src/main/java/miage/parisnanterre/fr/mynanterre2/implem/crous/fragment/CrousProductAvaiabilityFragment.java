package miage.parisnanterre.fr.mynanterre2.implem.crous.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.io.IOException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.ProduitGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousProductAvailabilityApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousProductAvaiabilityFragment extends Fragment {

    private CrousApiHelper crousApiHelper;
    private CrousProductAvailabilityApiHelper crousProductAvailabilityApiHelper;
    private Crous clickedCrous;
    private int clickedSimpleCrousId;
    private GridView gridView;
    private ProduitGridAdapter adapter;
    private ProgressBar progressBar;

    public CrousProductAvaiabilityFragment(int clickedSimpleCrousId){
        crousApiHelper = CrousApiHelper.getInstance();
        crousProductAvailabilityApiHelper = CrousProductAvailabilityApiHelper.getInstance();
        this.clickedSimpleCrousId = clickedSimpleCrousId;
    }

    public static CrousProductAvaiabilityFragment newInstance(int clickedSimpleCrousId) {
        return new CrousProductAvaiabilityFragment(clickedSimpleCrousId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.crous_product_availability, container, false);

        TextView title = v.findViewById(R.id.Title);
        title.setText("Produits proposés");

        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(x -> getActivity().onBackPressed());

        GetCrousAsync getCrousAsync = new GetCrousAsync();
        getCrousAsync.execute();

        progressBar = v.findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);

        gridView = v.findViewById(R.id.gridview);

        gridView.setOnItemClickListener((parent1, v13, position1, id1) -> {

            LayoutInflater factory = LayoutInflater.from(getContext());
            final View alertDialogView = factory.inflate(R.layout.dialog_box_dispo, null);

            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setView(alertDialogView);

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            Button btnOK = alertDialogView.findViewById(R.id.buttonok);
            Button btnKO = alertDialogView.findViewById(R.id.buttonko);

            btnOK.setOnClickListener(v1 -> {
                PostAvailability(alertDialog, position1, true);
            });

            btnKO.setOnClickListener(v2 -> {
                PostAvailability(alertDialog, position1, false);
            });

        });

        return v;
    }

    private void PostAvailability(AlertDialog alertDialog, int position, boolean isAvailable) {
        CrousProduct crousProduct = clickedCrous.getCrousProducts().get(position);
        PostAvailabilityAsync postAvailabilityAsync = new PostAvailabilityAsync(crousProduct, isAvailable);
        postAvailabilityAsync.execute();
        Toast.makeText(getContext(), "c'est noté!", Toast.LENGTH_SHORT).show();

        alertDialog.hide();

        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);
    }


    private final class GetCrousAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            clickedCrous = crousApiHelper.getCrous(clickedSimpleCrousId);
            return "executed";
        }
        @Override
        protected void onPostExecute(String result) {
            adapter = new ProduitGridAdapter(getContext(), clickedCrous);
            gridView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        }
    }

    private final class PostAvailabilityAsync extends AsyncTask<Void, Void, String> {

        private CrousProduct clickedCrousProduct;
        private boolean isAvailable;

        public PostAvailabilityAsync(CrousProduct clickedSimpleCrous, boolean isAvailable) {
            this.clickedCrousProduct = clickedSimpleCrous;
            this.isAvailable = isAvailable;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            try {
                crousProductAvailabilityApiHelper.createAvailability(isAvailable,clickedCrousProduct);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "executed";
        }
    }

}
