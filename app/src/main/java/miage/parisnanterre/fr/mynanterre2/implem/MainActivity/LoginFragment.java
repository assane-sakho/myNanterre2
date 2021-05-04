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

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LoginApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.MainActivity.CallbackFragment;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.apache.commons.lang3.StringUtils;

public class LoginFragment extends Fragment {

    View v;
    Button buttonLogin, buttonRegister;
    EditText Email, Password;
    CallbackFragment callbackFragment;

    String email, pass;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.login, container, false);

        Email = v.findViewById(R.id.Email);
        Password = v.findViewById(R.id.Password);

        buttonLogin = v.findViewById(R.id.btnLogin);
        buttonRegister = v.findViewById(R.id.btnRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                email = Email.getText().toString();
                pass = Password.getText().toString();

                //tester si l'utilisateur et le mot de passe sont corrects (qu'ils existent)

                if(StringUtils.isEmpty(email) || StringUtils.isEmpty(pass))
                {
                    Toast.makeText(v.getContext(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(callbackFragment != null)
                    {
                        Toast.makeText(v.getContext(), "Connexion en cours, veuillez patienter...", Toast.LENGTH_LONG).show();
                        LoginAsync loginAsync = new LoginAsync();
                        loginAsync.execute();
                        buttonLogin.setEnabled(false);
                        buttonRegister.setEnabled(false);
                    }
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callbackFragment != null)
                {
                    callbackFragment.changeFragment();
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

            boolean isLogged = loginApiHelper.login(email, pass);
            return "" + isLogged;

            }

        @Override
        protected void onPostExecute(String result) {
            if(result.equals("true"))
            {
                Toast.makeText(v.getContext(), "Connexion réussie", Toast.LENGTH_SHORT).show();
                callbackFragment.changeFragmentLoginSuccess();
                buttonLogin.setEnabled(true);
                buttonRegister.setEnabled(true);
            }
            else
            {
                Toast.makeText(v.getContext(), "Erreur : Email ou mot de passe incorrect, veuillez réessayer", Toast.LENGTH_SHORT).show();
                buttonLogin.setEnabled(true);
                buttonRegister.setEnabled(true);
            }
        }
    }
}