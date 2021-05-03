package miage.parisnanterre.fr.mynanterre2.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.helpers.api.UserApiHelper;

public class LoginFragment extends Fragment {

    Button buttonLogin, buttonRegister;
    EditText Username, Password;
    CallbackFragment callbackFragment;

    String username, pass;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login, container, false);

        Username = v.findViewById(R.id.Username);
        Password = v.findViewById(R.id.Password);

        buttonLogin = v.findViewById(R.id.btnLogin);
        buttonRegister = v.findViewById(R.id.btnRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                username = Username.getText().toString();
                pass = Password.getText().toString();

                //tester si l'utilisateur et le mot de passe sont corrects (qu'ils existent)

                if(StringUtils.isEmpty(username) || StringUtils.isEmpty(pass))
                {
                    Toast.makeText(v.getContext(), "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(callbackFragment != null)
                    {
                        callbackFragment.changeFragmentLoginSuccess();
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
}
