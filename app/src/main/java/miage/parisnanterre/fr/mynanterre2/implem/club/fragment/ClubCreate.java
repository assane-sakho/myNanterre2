package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.R;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.club.Type;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubTypeApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LoginApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.MainActivity.CallbackFragment;
import miage.parisnanterre.fr.mynanterre2.implem.MainActivity.RegisterFragment;


@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubCreate extends Fragment {

    private Spinner sClubsType;
    private ProgressBar progressBar;
    private ConstraintLayout llCreateClub;
    private ClubTypeApiHelper clubTypeApiHelper;
    private List<Type> clubTypeLoaded;
    private Button btnCreateClub;
    private String nomClub, mail, siteWeb, type, desc, contact;
    EditText etNomClub, etMail, etSiteWeb, etDesc, etContact;
    CallbackFragment callbackFragment;
    View v;
    Fragment fragment;
    FragmentManager fragmentManager;

    public ClubCreate() { }

    public static ClubCreate newInstance() { return new ClubCreate(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_club_create, container, false);

        clubTypeLoaded = new ArrayList<Type>();
        clubTypeApiHelper = ClubTypeApiHelper.getInstance();
        sClubsType = (Spinner) v.findViewById(R.id.spinner);
        progressBar = (ProgressBar) v.findViewById(R.id.progress4);
        llCreateClub = (ConstraintLayout) v.findViewById(R.id.llCreateClub);
        btnCreateClub = (Button) v.findViewById(R.id.btnCreateClub);
        etNomClub = (EditText) v.findViewById(R.id.nomCreateClub);
        etMail = (EditText) v.findViewById(R.id.mailCreateClub);
        etSiteWeb = (EditText) v.findViewById(R.id.siteWebCreateClub);
        etDesc = (EditText) v.findViewById(R.id.descCreateClub);
        etContact = (EditText) v.findViewById(R.id.contactCreateClub);

        btnCreateClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomClub = etNomClub.getText().toString();
                mail = etMail.getText().toString();
                siteWeb = etSiteWeb.getText().toString();
                type = sClubsType.getSelectedItem().toString();
                desc = etDesc.getText().toString();
                contact = etContact.getText().toString();

                if(StringUtils.isEmpty(mail) || StringUtils.isEmpty(siteWeb) || StringUtils.isEmpty(nomClub) || StringUtils.isEmpty(desc) || StringUtils.isEmpty(type) || StringUtils.isEmpty(contact))
                {
                    Toast.makeText(v.getContext(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(v.getContext(), "Création du club en cours, veuillez patienter...", Toast.LENGTH_LONG).show();
                ClubCreate.CreateClubAsync CCsync = new ClubCreate.CreateClubAsync();
                CCsync.execute();
                btnCreateClub.setEnabled(false);
            }
        });

        progressBar.setVisibility(View.VISIBLE);
        llCreateClub.setVisibility(View.GONE);
        ClubCreate.GetClubsTypeAsync getClubsTypeAsync = new ClubCreate.GetClubsTypeAsync();
        getClubsTypeAsync.execute();

        return v;
    }

    public void setCallbackFragment(CallbackFragment callbackFragment)
    {
        this.callbackFragment = callbackFragment;
    }

    private final class CreateClubAsync extends AsyncTask<Void, Void, String> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            ClubApiHelper clubApiHelper = ClubApiHelper.getInstance();
            UserApiHelper userApiHelper = UserApiHelper.getInstance();
            User creator = userApiHelper.getUserConnected(); //user de test

            SimpleClub simpleClub = new SimpleClub();
            simpleClub.setName(nomClub)
                    .setWebsite(siteWeb)
                    .setContact(contact)
                    .setMail(mail)
                    .setDescription(desc)
                    .setType(clubTypeLoaded.stream().filter(unType -> unType.getName().equals(type)).findFirst().get())
                    .setCreator(creator);

            Club club = new Club(simpleClub);

            try {
                club = clubApiHelper.createClub(club);
            } catch (IOException e) {
                e.printStackTrace();
            }

            boolean isCreated;

            if(club.getId() != 0){
                isCreated = true;
            }else{
                isCreated = false;
            }

            return "" + isCreated;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result.equals("true"))
            {
                Toast.makeText(v.getContext(), "Le club a été créé.", Toast.LENGTH_SHORT).show();
                fragment = null;
                fragmentManager = getFragmentManager();
                try {
                    fragment = (Fragment) MesClubs.class.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment

                fragmentManager.beginTransaction()
                        .replace(R.id.flContent, fragment)
                        .addToBackStack(null)
                        .commit();
            }
            else
            {
                Toast.makeText(v.getContext(), "Erreur 500 !.", Toast.LENGTH_SHORT).show();
                btnCreateClub.setEnabled(true);
            }
        }
    }

    /**
     * chargement des clubs en fond et affichage d'un cercle de chargement le temps que sa charge
     */

    private final class GetClubsTypeAsync extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            List<Type> clubTypes = new ArrayList<Type>();

            try {
                clubTypes = clubTypeApiHelper.getAllTypes();
            } catch (Exception e) {
                e.printStackTrace();
            }

            clubTypeLoaded.addAll(clubTypes);

            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {

            List<String> clubT = new ArrayList<String>();

            for (Type t : clubTypeLoaded){
                clubT.add(t.getName());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, clubT);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            sClubsType.setAdapter(adapter);

            progressBar.setVisibility(View.GONE);
            llCreateClub.setVisibility(View.VISIBLE);
        }

    }
}