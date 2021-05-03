package miage.parisnanterre.fr.mynanterre2.implem.MainActivity;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.fragment.CallbackFragment;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin, buttonRegister;
    EditText Username, Password;
    CallbackFragment callbackFragment;

    String username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
}