package miage.parisnanterre.fr.mynanterre2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.Cgu;
import miage.parisnanterre.fr.mynanterre2.implem.LiveTweet;
import miage.parisnanterre.fr.mynanterre2.implem.PlanBatiments;
import miage.parisnanterre.fr.mynanterre2.implem.library.ListeEspacesBu;

public class SupportFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.support, container, false);

        EditText SupportMessage = v.findViewById(R.id.SupportMessage);

        Button Valider = v.findViewById(R.id.Valider);
        Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Envoyer mail
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"dasrahul2297@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Message de support MyNanterre");
                email.putExtra(Intent.EXTRA_TEXT, SupportMessage.getText());
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choisissez votre application de messagerie :"));

            }
        });

        return v;
    }
}

