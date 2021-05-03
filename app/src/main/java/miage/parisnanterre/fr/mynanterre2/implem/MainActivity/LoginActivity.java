package miage.parisnanterre.fr.mynanterre2.implem.MainActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.fragment.AccueilFragment;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LoginApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.Accueil;
import miage.parisnanterre.fr.mynanterre2.implem.MainActivity.RegisterFragment;

public class LoginActivity extends AppCompatActivity implements CallbackFragment {

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginApiHelper LAH = LoginApiHelper.getInstance();

        LAH.logout();

        if(LAH.isUserAuthenticated())
        {
            skipLogin();
        }
        else
        {
            addFragment();
        }
    }

    public void skipLogin()
    {
        Intent myIntent = new Intent(this, Accueil.class);
        startActivity(myIntent);
    }

    public void addFragment()
    {
        LoginFragment fragment = new LoginFragment();
        fragmentManager = getSupportFragmentManager();
        fragment.setCallbackFragment(this);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ContentLogin, fragment);
        fragmentTransaction.commit();
    }


    public void replaceFragment(){

        fragment = new RegisterFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.ContentLogin, fragment);
        fragmentTransaction.commit();

    }

    public void LoginSuccess(){
        Intent myIntent = new Intent(this, Accueil.class);
        startActivity(myIntent);
    }

    @Override
    public void changeFragment() {
        replaceFragment();
    }

    @Override
    public void changeFragmentLoginSuccess() {
        LoginSuccess();
    }

    @Override
    public void changeFragmentRegisterSuccess() {
        LoginSuccess();
    }


}