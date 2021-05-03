package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import androidx.annotation.RequiresApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserClubApiHelper;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubInfoFragment extends Fragment {

    private final Club club;

    private ClubApiHelper clubApiHelper;
    UserApiHelper userApiHelper ;
    User userConnected ;
    List<Integer> followedClubs;//les clubs follow d'un user
    ImageView Follow;

    /**
     * Constructeur qui récupère l'id du club qu'on veut afficher
     */

    public ClubInfoFragment(int simpleClubId){
        this.clubApiHelper = ClubApiHelper.getInstance();
        SimpleClub simpleClub = clubApiHelper.getSimpleClub(simpleClubId);
        club = new Club(simpleClub);
    }

    public static ClubInfoFragment newInstance(int simpleClubId) {
        return new ClubInfoFragment(simpleClubId);
    }

    /**
     * On crée l'affichage avec les données du club
     */


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
        TextView mail = v1.findViewById(R.id.tvMail);
        TextView web = v1.findViewById(R.id.tvWebsite);
        TextView contact = v1.findViewById(R.id.tvContact);


        titre.setText("Clubs");
        Bitmap bitmap = BitmapFactory.decodeByteArray(club.getImageBytes(), 0, club.getImageBytes().length);
        img.setImageBitmap(bitmap);
        nom.setText(club.getName());
        nom.setAutoSizeTextTypeUniformWithConfiguration(16,26,1, TypedValue.COMPLEX_UNIT_SP);
        cat.setText("Catégorie : " + club.getType().getName());
        creator.setText("Créateur : " + club.getCreator().getFullName());
        desc.setText(club.getDescription());
        date.setText("Date de création : " + club.getCreationDate());

        if(!club.isCertificate()){
            v1.findViewById(R.id.certif).setVisibility(View.INVISIBLE);
        }

        ImageView imgContact = v1.findViewById(R.id.imgContact);
        if(StringUtils.isEmpty(club.getContact()))
        {
            imgContact.setVisibility(v1.GONE);
        }

        ImageView imgMail = v1.findViewById(R.id.imgMail);
        if(StringUtils.isEmpty(club.getMail()))
        {
            imgMail.setVisibility(v1.GONE);
        }

        ImageView imgWeb = v1.findViewById(R.id.imgWeb);
        if(StringUtils.isEmpty(club.getWebsite()))
        {
            imgWeb.setVisibility(v1.GONE);
        }

        mail.setText(club.getMail());
        web.setText(club.getWebsite());
        contact.setText(club.getContact());


        //Partie follow / unfollow
        Follow = v1.findViewById(R.id.ivFollow);
        Follow.setVisibility(View.INVISIBLE);
        getfollowedClubs();

        /*if(followedClubs.contains(club.getId())){
            clickButton.setText("UNFOLLOW");
            clickButton.setBackgroundColor(Color.RED);
        }
        else{
            clickButton.setText("FOLLOW");
            clickButton.setBackgroundColor(Color.BLUE);
        }*/

        Follow.setOnClickListener( new View.OnClickListener() {
            @Override public void onClick(View v) {
                //Si le club n'appartient pas à la liste des clubs follow -> qu'il veut follow le club
                if(!followedClubs.contains(club.getId())){ //&& clickButton.getText()=="FOLLOW"
                    follow();
                }
                else{
                    unFollow();
                }
            } });
        //tester si le user appartient à la liste de follow
        // gestion du click :
        // this.user.addClubSuivi(club) //pas sure si c'est ici ou dans user
        //Button follow = v1.FindViewById()
        //follow.setOnClick(Methode follow avec l'id du club)
        //set button disable
        //set button visible

        ImageView back = v1.findViewById(R.id.back);

        back.setOnClickListener(v -> getActivity().onBackPressed());

        return v1;
    }
    /**
     * Récupère les données des clubs de l'api
     */
    public void getfollowedClubs() {
        //progressBar.setVisibility(View.VISIBLE);
        GetFollowedClubsAsync getfollowClubsAsync = new GetFollowedClubsAsync();
        getfollowClubsAsync.execute();
    }
    public void follow() {
        //progressBar.setVisibility(View.VISIBLE);
        FollowClubsAsync followClubsAsync = new FollowClubsAsync();
        followClubsAsync.execute();
    }

    public void unFollow() {
        //progressBar.setVisibility(View.VISIBLE);
        UnFollowClubsAsync unfollowClubsAsync = new UnFollowClubsAsync();
        unfollowClubsAsync.execute();
    }

    private final class GetFollowedClubsAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            userApiHelper = UserApiHelper.getInstance();
            userConnected = userApiHelper.getUserConnected();
            followedClubs = userConnected.getFollowedClubsIds();
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Follow.setVisibility(View.VISIBLE);

            if(followedClubs.contains(club.getId())){
                Follow.setImageResource(R.drawable.coeur_plein);
            }
            else{
                Follow.setImageResource(R.drawable.coeur_vide);
            }
        }
    }

    /**
     * chargement des clubs en fond et affichage d'un cercle de chargement le temps que sa charge
     */

    private final class FollowClubsAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            Follow.setVisibility(View.INVISIBLE);
            userApiHelper = UserApiHelper.getInstance();
            userConnected = userApiHelper.getUserConnected();
            UserClubApiHelper userClubApiHelper = new UserClubApiHelper();
            try {
                userClubApiHelper.followClub(club);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Follow.setImageResource(R.drawable.coeur_plein);
            followedClubs.add(club.getId());
            Toast.makeText(getContext(), "Vous suivez ce club", Toast.LENGTH_SHORT).show();
            Follow.setVisibility(View.VISIBLE);
        }
    }

    private final class UnFollowClubsAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            Follow.setVisibility(View.INVISIBLE);
            UserClubApiHelper userClubApiHelper = new UserClubApiHelper();
            try {
                userClubApiHelper.unFollowClub(club);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Follow.setImageResource(R.drawable.coeur_vide);
            followedClubs.removeIf(id->id==club.getId());
            Toast.makeText(getContext(), "Vous ne suivez plus ce club", Toast.LENGTH_SHORT).show();
            Follow.setVisibility(View.VISIBLE);
        }
    }


    /**
     * On récupère les données du club grâce à son id
     */


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

        }

    }
}