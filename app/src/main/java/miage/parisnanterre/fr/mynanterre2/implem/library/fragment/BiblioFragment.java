package miage.parisnanterre.fr.mynanterre2.implem.library.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import miage.parisnanterre.fr.mynanterre2.implem.library.R;

public class BiblioFragment extends Fragment {

    private BiblioViewModel mViewModel;

    public static BiblioFragment newInstance() {
        return new BiblioFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.biblio_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BiblioViewModel.class);
        // TODO: Use the ViewModel
    }

}