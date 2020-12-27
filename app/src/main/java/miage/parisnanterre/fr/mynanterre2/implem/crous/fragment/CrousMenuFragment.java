package miage.parisnanterre.fr.mynanterre2.implem.crous.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import miage.parisnanterre.fr.mynanterre2.R;

public class CrousMenuFragment extends Fragment {

    public static CrousMenuFragment newInstance() {
        return new CrousMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.crous_menu, container, false);


        TextView title = v.findViewById(R.id.Title);
        title.setText("Crous Cafet' La carte 2019/2020");

        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(x -> getActivity().onBackPressed());

        return v;
    }
}
