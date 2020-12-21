package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import androidx.annotation.RequiresApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubInfoFragment extends Fragment {

    private final Club club;

    private ClubApiHelper clubApiHelper;

    public ClubInfoFragment(int simpleClubId){
        this.clubApiHelper = ClubApiHelper.getInstance();
        SimpleClub simpleClub = clubApiHelper.getSimpleClub(simpleClubId);
        club = new Club(simpleClub);
    }

    public static ClubInfoFragment newInstance(int simpleClubId) {
        return new ClubInfoFragment(simpleClubId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v1 = inflater.inflate(R.layout.club_info_fragment, container, false);

        GetClubPublicationsAsync getClubPublicationsAsync = new GetClubPublicationsAsync();
        getClubPublicationsAsync.execute();

        TextView titre = v1.findViewById(R.id.Title);
        ImageView img = v1.findViewById(R.id.imageClub);
        TextView nom = v1.findViewById(R.id.nomClub);
        TextView cat = v1.findViewById(R.id.catClub);
        TextView creator = v1.findViewById(R.id.creatorClub);
        TextView desc = v1.findViewById(R.id.descClub);
        TextView date = v1.findViewById(R.id.dateClub);

        titre.setText("Clubs");
        Bitmap bitmap = BitmapFactory.decodeByteArray(club.getImage(), 0, club.getImage().length);
        img.setImageBitmap(bitmap);
        nom.setText(club.getName());
        cat.setText("Catégorie : " + club.getType().getName());
        creator.setText("Président(e) : " + club.getCreator().getFullName());
        desc.setText(club.getDescription());
        date.setText("Date de création : " + club.getCreationDate());

        if(!club.isCertificate()){
            v1.findViewById(R.id.certif).setVisibility(View.INVISIBLE);
        }

        ImageView back = v1.findViewById(R.id.back);

        back.setOnClickListener(v -> getActivity().onBackPressed());

        return v1;
    }

    private final class GetClubPublicationsAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            try {
                club.setPublications(clubApiHelper.getPublications(club.getId()));
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
          //TODO Afficher les publications
        }

    }
}