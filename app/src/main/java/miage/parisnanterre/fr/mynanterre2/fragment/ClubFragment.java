package miage.parisnanterre.fr.mynanterre2.fragment;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.clubViewModel;

public class ClubFragment extends Fragment {

    private clubViewModel mViewModel;
    private ClubApiHelper clubApiHelper;

    public static ClubFragment newInstance() {
        return new ClubFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.club_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(clubViewModel.class);

        clubApiHelper = ClubApiHelper.getInstance();
        GetClubsAsync getLibrariesAsync = new GetClubsAsync();
        getLibrariesAsync.execute();
    }

    private final class GetClubsAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            clubApiHelper.getClubs();

            return "executed";
        }

    }


}