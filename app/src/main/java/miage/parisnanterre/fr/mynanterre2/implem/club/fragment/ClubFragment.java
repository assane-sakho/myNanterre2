package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import androidx.annotation.RequiresApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerClubAdapter;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubFragment extends Fragment {

    private RecyclerClubAdapter recyclerClubAdapter;
    private ClubApiHelper clubApiHelper;
    private List<SimpleClub> clubLoaded;
    private ProgressBar progressBar;

    public static ClubFragment newInstance() {
        return new ClubFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.club_fragment, container, false);

        clubApiHelper = ClubApiHelper.getInstance();
        clubApiHelper.resetPaginationIndex();

        RecyclerView rvClub = v.findViewById(R.id.recyclerViewClub);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(false);

        progressBar = (ProgressBar) v.findViewById(R.id.progress);
        clubLoaded = new ArrayList<>();
        recyclerClubAdapter = new RecyclerClubAdapter(getContext(), clubLoaded);

        rvClub.setAdapter(recyclerClubAdapter);

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        final androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerClubAdapter.getFilter().filter(newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        GetClubsAsync getLibrariesAsync = new GetClubsAsync();
        getLibrariesAsync.execute();
    }

    private final class GetClubsAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            clubLoaded.addAll(clubApiHelper.getMoreSimpleClubs());
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            recyclerClubAdapter.notifyDataSetChanged();
        }

    }

}