package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.github.mikephil.charting.data.BarEntry;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerBiblioAdapter;
import miage.parisnanterre.fr.mynanterre2.adapter.RecyclerClubAdapter;
import miage.parisnanterre.fr.mynanterre2.api.library.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.Responsable;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.Accueil;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubFragment;
import miage.parisnanterre.fr.mynanterre2.implem.club.viewModel.clubViewModel;
import miage.parisnanterre.fr.mynanterre2.implem.library.viewModel.BiblioViewModel;

public class ThirdFragment extends Fragment {

    private View v;
    private RecyclerView rvBiblio;
    RecyclerBiblioAdapter recyclerBiblioAdapter;


    private BiblioViewModel mViewModel;
    private RecyclerClubAdapter rca;
    private Library clickedLibrary;

    public ThirdFragment() {
        // Required empty public constructor
    }

    public ThirdFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }
    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_third, container, false);

        rvBiblio = v.findViewById(R.id.recyclerViewBiblio);
        recyclerBiblioAdapter = new RecyclerBiblioAdapter(clickedLibrary);

        //rvBiblio.setLayoutManager(new LinearLayoutManager(v.getContext()));

        rvBiblio.setAdapter(recyclerBiblioAdapter);

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