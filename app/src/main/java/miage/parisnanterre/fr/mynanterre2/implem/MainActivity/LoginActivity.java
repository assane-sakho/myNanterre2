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



}