package miage.parisnanterre.fr.mynanterre2.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.user.Type;
import miage.parisnanterre.fr.mynanterre2.api.user.User;

public class RegisterFragment extends Fragment {

    Button buttonLogin, buttonRegister;
    EditText nom, prenom, email, password;
    CallbackFragment callbackFragment;

    User user;
    Type UserType;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.register, container, false);

        nom = v.findViewById(R.id.nom);
        prenom = v.findViewById(R.id.prenom);
        password = v.findViewById(R.id.password);
        email = v.findViewById(R.id.mail);

        buttonLogin = v.findViewById(R.id.btnLogin);
        buttonRegister = v.findViewById(R.id.btnRegister);

        Type userType = new Type("utilisateur");


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                User u = new User(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(), password.getText().toString(), userType);

                if(callbackFragment != null)
                {
                    callbackFragment.changeFragmentRegisterSuccess();
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
