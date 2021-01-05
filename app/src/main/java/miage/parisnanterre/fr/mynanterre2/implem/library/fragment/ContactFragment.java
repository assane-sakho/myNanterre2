package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;




import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerBiblioContactAdapter;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerClubAdapter;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.implem.library.viewModel.BiblioViewModel;

public class ContactFragment extends Fragment {

    private View v;
    private RecyclerView rvBiblio;
    RecyclerBiblioContactAdapter recyclerBiblioContactAdapter;


    private BiblioViewModel mViewModel;
    private RecyclerClubAdapter rca;
    private Library clickedLibrary;

    public ContactFragment() {
        // Required empty public constructor
    }

    public ContactFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }
    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.contact_view, container, false);

        rvBiblio = v.findViewById(R.id.recyclerViewBiblio);
        recyclerBiblioContactAdapter = new RecyclerBiblioContactAdapter(clickedLibrary);

        //rvBiblio.setLayoutManager(new LinearLayoutManager(v.getContext()));

        rvBiblio.setAdapter(recyclerBiblioContactAdapter);

        /*
        try{

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

         */
        return v;
    }
















    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BiblioViewModel.class);
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

}