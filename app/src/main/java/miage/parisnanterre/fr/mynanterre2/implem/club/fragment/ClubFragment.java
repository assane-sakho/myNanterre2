package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerClubAdapter;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.club.viewModel.clubViewModel;

public class ClubFragment extends Fragment {

    private View v;
    private clubViewModel mViewModel;
    private RecyclerView rvClub;
    private RecyclerClubAdapter rca;
    private ClubApiHelper clubApiHelper;

    public static ClubFragment newInstance() {
        return new ClubFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.club_fragment, container, false);

        clubApiHelper = ClubApiHelper.getInstance();
        GetClubsAsync getLibrariesAsync = new GetClubsAsync();
        getLibrariesAsync.execute();

        setHasOptionsMenu(true);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(clubViewModel.class);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rca.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final class GetClubsAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            clubApiHelper.getClubs();
            return "executed";
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(String result) {
            rvClub = v.findViewById(R.id.recyclerViewClub);
            rca = new RecyclerClubAdapter(getContext());

            rvClub.setAdapter(rca);
            ClubFragment.newInstance();
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
            rvClub.addItemDecoration(dividerItemDecoration);
        }

    }

}