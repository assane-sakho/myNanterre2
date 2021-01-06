package miage.parisnanterre.fr.mynanterre2.implem.crous.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.crous.SimpleCrous;
import miage.parisnanterre.fr.mynanterre2.helpers.api.CrousApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.LocalisationListener;
import miage.parisnanterre.fr.mynanterre2.implem.crous.adapter.CrousLocalisationAdapter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousLocalisationFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private CrousApiHelper crousApiHelper;
    private List<SimpleCrous> simpleCrousList;
    private ProgressBar progressBar;

    public CrousLocalisationFragment() {
        crousApiHelper = CrousApiHelper.getInstance();
        simpleCrousList = new ArrayList<>();
    }

    public static CrousLocalisationFragment newInstance() {
        return new CrousLocalisationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        View v = inflater.inflate(R.layout.crous_localisation, container, false);

        progressBar = v.findViewById(R.id.progressBar3);
        progressBar.setVisibility(View.VISIBLE);

        TextView title = v.findViewById(R.id.Title);
        title.setText("Informations de localisation");
        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(x -> getActivity().onBackPressed());

        recyclerView = v.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        GetSimpleCrousListAsync getSimpleCrousListAsync = new GetSimpleCrousListAsync();
        getSimpleCrousListAsync.execute();

        return v;
    }

    private final class GetSimpleCrousListAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            try {
                simpleCrousList = crousApiHelper.getAllSimpleCrous();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            LocalisationListener userPosition = new LocalisationListener(getContext());
            double latitudeUser = userPosition.getLatitude();
            double longitudeUser = userPosition.getLongitude();

            Collections.sort(simpleCrousList, Comparator.comparing(SimpleCrous::isOpen));
            Collections.reverse(simpleCrousList);
            adapter = new CrousLocalisationAdapter(simpleCrousList, latitudeUser, longitudeUser);

            progressBar.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter);
        }
    }
}