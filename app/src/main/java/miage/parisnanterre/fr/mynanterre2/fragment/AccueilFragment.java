package miage.parisnanterre.fr.mynanterre2.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.io.IOException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LoginApiHelper;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.Cgu;
import miage.parisnanterre.fr.mynanterre2.implem.LiveTweet;
import miage.parisnanterre.fr.mynanterre2.implem.PlanBatiments;


/**
 * Created by Sankar Vijay on 18/01/2019.
 */
public class AccueilFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.accueil, container, false);

        LoginAsync loginAsync = new LoginAsync();
        loginAsync.execute();

        Button mButton = v.findViewById(R.id.cgu);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create intent
                Intent intent = new Intent(v.getContext(), Cgu.class);
                //Start details activity
                startActivity(intent);
            }
        });

        Button TweetButton = v.findViewById(R.id.Tweet);
        TweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(v.getContext(), LiveTweet.class);
                Bundle extras = new Bundle();
                myIntent.putExtras(extras);
                v.getContext().startActivity(myIntent);
            }
        });

        ImageView planBat = v.findViewById(R.id.planBat);
        planBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), PlanBatiments.class);
                startActivity(myIntent);
            }
        });
        return v;
    }
    private final class LoginAsync extends AsyncTask<Void, Void, String> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            LoginApiHelper loginApiHelper = LoginApiHelper.getInstance();
            loginApiHelper.logout(); //Deconnexion

            if(loginApiHelper.isUserAuthenticated()) //si l'utilisateur est connecté (id et token stocké)
            {
                return "";
            }
            else
            {
                /* Exemple connexion */
                boolean isLogged = loginApiHelper.login("test@parisnanterre.fr", "P7dBsRCPtg5bf4vy4eePg");
                int id = loginApiHelper.getUserId();
                return "" + isLogged;

                /* Exemple d'inscription */
//                boolean isSigned;
//                try {
//                     isSigned = loginApiHelper.signIn("test", "testeur2", "test@parisnanterre.fr", "P7dBsRCPtg5bf4vy4eePg");
//                    int userId = loginApiHelper.getUserId();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    isSigned = false;
//                }
//              return "" + isSigned;
            }
        }

        @Override
        protected void onPostExecute(String result) {
           // todo
        }
    }

}