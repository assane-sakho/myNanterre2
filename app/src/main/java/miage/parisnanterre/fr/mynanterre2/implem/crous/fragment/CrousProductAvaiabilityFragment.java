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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.ListFragment;

import java.io.IOException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.ProduitGridAdapter;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousProductAvailabilityApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousProductAvaiabilityFragment extends ListFragment {

    private CrousApiHelper crousApiHelper;
    private CrousProductAvailabilityApiHelper crousProductAvailabilityApiHelper;
    private Crous clickedCrous;
    private int clickedSimpleCrousId;
    private GridView gridView;

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

        View v = inflater.inflate(R.layout.liste_crous, container, false);

        GetCrousAsync getCrousAsync = new GetCrousAsync();
        getCrousAsync.execute();

        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(vx -> getActivity().onBackPressed());

        gridView = v.findViewById(R.id.gridview);

        gridView.setOnItemClickListener((parent1, v13, position1, id1) -> {

            LayoutInflater factory1 = LayoutInflater.from(getContext());
            final View alertDialogView1 = factory1.inflate(R.layout.dialog_box_dispo, null);
            AlertDialog.Builder alertDialogBuilder1;
            alertDialogBuilder1 = new AlertDialog.Builder(getContext());
            alertDialogBuilder1.setView(alertDialogView1);

            Button btnOK = alertDialogView1.findViewById(R.id.buttonok);
            Button btnKO = alertDialogView1.findViewById(R.id.buttonko);

            btnOK.setOnClickListener(v1 -> {
                PostAvailability(position1, true);
            });

            btnKO.setOnClickListener(v2 -> {
                PostAvailability(position1, false);
            });

            alertDialogBuilder1.create().show();
        });

        return v;
    }

    private void PostAvailability(int position, boolean isAvailable) {
        CrousProduct crousProduct = clickedCrous.getCrousProducts().get(position);
        PostAvailabilityAsync postAvailabilityAsync = new PostAvailabilityAsync(crousProduct, isAvailable);
        postAvailabilityAsync.execute();
        Toast.makeText(getContext(), "c'est noté!", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(CrousProductAvailability.this, ListeCrous.class));
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
            gridView.setAdapter(new ProduitGridAdapter(getContext(), clickedCrous));
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
