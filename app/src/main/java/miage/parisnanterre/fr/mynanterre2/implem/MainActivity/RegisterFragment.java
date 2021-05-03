package miage.parisnanterre.fr.mynanterre2.implem.MainActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.user.Type;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LoginApiHelper;

public class RegisterFragment extends Fragment {

    View v;
    Button buttonBacktoLogin, buttonRegister;
    EditText nom, prenom, email, password;
    CallbackFragment callbackFragment;

    User user;
    Type UserType;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.register, container, false);

        nom = v.findViewById(R.id.nom);
        prenom = v.findViewById(R.id.prenom);
        password = v.findViewById(R.id.password);
        email = v.findViewById(R.id.mail);

        buttonRegister = v.findViewById(R.id.btnRegister);

        Type userType = new Type("utilisateur");


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                if(StringUtils.isEmpty(email.getText().toString()) || StringUtils.isEmpty(password.getText().toString()))
                {
                    Toast.makeText(v.getContext(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                }
                if(callbackFragment != null)
                {
                    LoginAsync loginAsync = new LoginAsync();
                    loginAsync.execute();
                }
            }
        });



        return v;
    }

    public void setCallbackFragment(CallbackFragment callbackFragment)
    {
        this.callbackFragment = callbackFragment;
    }



    private final class LoginAsync extends AsyncTask<Void, Void, String> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            LoginApiHelper loginApiHelper = LoginApiHelper.getInstance();
            loginApiHelper.logout(); //Deconnexion

            /* Exemple d'inscription */
            boolean isSigned;
            try {
                isSigned = loginApiHelper.signIn(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(), password.getText().toString());
                int userId = loginApiHelper.getUserId();
            } catch (IOException e) {
                e.printStackTrace();
                isSigned = false;
            }
            return "" + isSigned;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result.equals("true"))
            {
                callbackFragment.changeFragmentRegisterSuccess();
            }
            else
            {
                Toast.makeText(v.getContext(), "Erreur : l'adresse mail existe déjà dans la base de données.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
