package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;

public class ConditionPretFragment extends Fragment {

    private View v;
    private Library clickedLibrary;

    public ConditionPretFragment(){}
    public ConditionPretFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.condition_pret_view, container, false);


        return v;
    }


}
