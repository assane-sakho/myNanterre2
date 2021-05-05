package miage.parisnanterre.fr.mynanterre2.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerActuAdapter;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserClubApiHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActuFragment extends Fragment {

    private RecyclerActuAdapter recyclerActuAdapter;
    private UserClubApiHelper UserClubApiHelper;
    private List<Publication> publicationLoad;
    private ProgressBar progressBar;
    private TextView tvMsg;

    public static ActuFragment newInstance() {
        return new ActuFragment();
    }


    /**
     * à la création de l'affichage on initialise le recyclerview avec les données récupérer dans la table Club de l'api,
     * on spécifie qu'au scroll de la page on charge de nouvelle donnée pour le recyclerview et on spécifie que la page possède un menu optionnel qui
     * est le bouton search sur le menu principal de la page
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_actu, container, false);
        tvMsg = v.findViewById(R.id.msg);
        tvMsg.setVisibility(View.INVISIBLE);

        //UserClubApiHelper.resetPaginationIndex();

        RecyclerView rvActu = v.findViewById(R.id.recyclerViewActu);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(false);

        progressBar = (ProgressBar) v.findViewById(R.id.progress2);
        publicationLoad = new ArrayList<>();
        recyclerActuAdapter = new RecyclerActuAdapter(getContext(), publicationLoad);

        rvActu.setAdapter(recyclerActuAdapter);

        rvActu.setLayoutManager(mLayoutManager);

        rvActu.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1)) {
                    fetchData();
                }
            }
        });

        ActuFragment.newInstance();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rvActu.addItemDecoration(dividerItemDecoration);

        fetchData();

        return v;
    }


    /**
     * Récupère les données des publications de l'api
     */

    public void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        ActuFragment.GetActuAsync getLibrariesAsync = new ActuFragment.GetActuAsync();
        getLibrariesAsync.execute();
    }

    /**
     * chargement des publications en fond et affichage d'un cercle de chargement le temps que sa charge
     */

    private final class GetActuAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {

            try {
                UserClubApiHelper = UserClubApiHelper.getInstance();
                List<Publication> tmpList = UserClubApiHelper.getFollowedClubsPublication()
                        .stream()
                        .filter(publi -> !publicationLoad.contains(publi))
                        .collect(Collectors.toList());

                publicationLoad.addAll(tmpList);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            if (publicationLoad.size() == 0){
                tvMsg.setVisibility(View.VISIBLE);
            }
            progressBar.setVisibility(View.GONE);
            recyclerActuAdapter.notifyDataSetChanged();
        }

    }

}