package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;

import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerMesClubsAdapter;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.fragment.ClubFragment;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;



@RequiresApi(api = Build.VERSION_CODES.O)
public class MesClubs extends Fragment {

    private RecyclerMesClubsAdapter recyclerMesClubsAdapter;
    private ClubApiHelper clubApiHelper;
    private List<SimpleClub> clubLoaded;
    private ProgressBar progressBar;
    private TextView tvMsg;

    //getfollowedclub
    UserApiHelper userApiHelper ;
    User userConnected ;

    public static ClubFragment newInstance() {
        return new ClubFragment();
    }

    /**
     * à la création de l'affichage on initialise le recyclerview avec les données récupérer dans la table Club de l'api,
     * on spécifie qu'au scroll de la page on charge de nouvelle donnée pour le recyclerview et on spécifie que la page possède un menu optionnel qui
     * est le bouton search sur le menu principal de la page
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mes_clubs, container, false);

        clubApiHelper = ClubApiHelper.getInstance();
        clubApiHelper.resetPaginationIndex();

        tvMsg = v.findViewById(R.id.msg2);
        tvMsg.setVisibility(View.INVISIBLE);

        RecyclerView rvClub = v.findViewById(R.id.recyclerMesClubs);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(false);

        progressBar = (ProgressBar) v.findViewById(R.id.progress3);
        clubLoaded = new ArrayList<>();
        recyclerMesClubsAdapter = new RecyclerMesClubsAdapter(getContext(), clubLoaded);

        rvClub.setAdapter(recyclerMesClubsAdapter);

        rvClub.setLayoutManager(mLayoutManager);

        rvClub.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1)) {
                    fetchData();
                }
            }
        });

        ClubFragment.newInstance();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rvClub.addItemDecoration(dividerItemDecoration);

        setHasOptionsMenu(true);

        fetchData();

        return v;
    }

    /**
     * On créer la menu search
     */

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem listeMesClubs = menu.findItem(R.id.ListeMesClubs);
        listeMesClubs.setVisible(false);

        MenuItem creerClub = menu.findItem(R.id.CreateClub);
        creerClub.setVisible(false);

        MenuItem item = menu.findItem(R.id.action_search);

        final androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerMesClubsAdapter.getFilter().filter(newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * Récupère les données des clubs de l'api
     */

    public void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        MesClubs.GetClubsAsync getLibrariesAsync = new MesClubs.GetClubsAsync();
        getLibrariesAsync.execute();

    }

    /**
     * chargement des clubs en fond et affichage d'un cercle de chargement le temps que sa charge
     */

    private final class GetClubsAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            clubLoaded.addAll(clubApiHelper.getCreatedClubs());
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            if (clubLoaded.size() == 0){
                tvMsg.setVisibility(View.VISIBLE);
            }
            progressBar.setVisibility(View.GONE);
            recyclerMesClubsAdapter.notifyDataSetChanged();
        }

    }
}