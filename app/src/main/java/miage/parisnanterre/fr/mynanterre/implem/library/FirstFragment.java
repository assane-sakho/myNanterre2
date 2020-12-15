package miage.parisnanterre.fr.mynanterre.implem.library;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.api.library.Library;

public class FirstFragment extends Fragment {

    View v;
    private Library clickedLibrary;
    public FirstFragment() {
        // Required empty public constructor
    }

    public FirstFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_first, container, false);

        try {

            //BU Name
            TextView txtview = v.findViewById(R.id.NameBU);
            txtview.setText(clickedLibrary.getName());


        }
        catch(Exception e)
        {
            e.getStackTrace();
        }


        return v;
    }

}