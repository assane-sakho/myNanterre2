package miage.parisnanterre.fr.mynanterre2.implem.library;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.github.mikephil.charting.data.BarEntry;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.Responsable;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.Accueil;

public class ThirdFragment extends Fragment {

    private View v;

    private Library clickedLibrary;

    public ThirdFragment() {
        // Required empty public constructor
    }

    public ThirdFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }
    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_third, container, false);

        try{
            //Données du 3e tab :
            TextView txtResponsable = v.findViewById(R.id.ResponsableName);
            txtResponsable.setText(clickedLibrary.getResponsables().stream().map(Responsable::getFullName).collect(Collectors.joining("\n")));


            //MAIL
            TextView txtEmail = v.findViewById(R.id.email);
            ImageView imgEmail = v.findViewById(R.id.imgMail);
            if(!StringUtils.isEmpty(clickedLibrary.getMail()))
            {
                imgEmail.setVisibility(v.VISIBLE);
                txtEmail.setVisibility(v.VISIBLE);

                //PLACEMENTS
                RelativeLayout.LayoutParams lpTxt = (RelativeLayout.LayoutParams) txtEmail.getLayoutParams();
                lpTxt.setMargins(200, 45, 0, 0);
                txtEmail.setLayoutParams(lpTxt);

                RelativeLayout.LayoutParams lpImg = (RelativeLayout.LayoutParams) imgEmail.getLayoutParams();
                lpImg.setMargins(20, 30, 0, 0);
                imgEmail.setLayoutParams(lpImg);




                txtEmail.setText(clickedLibrary.getMail());
            }
            else
            {
                txtEmail.setVisibility(v.GONE);
                imgEmail.setVisibility(v.GONE);
            }

            //TELEPHONE
            TextView txtTel = v.findViewById(R.id.tel);
            ImageView imgTel = v.findViewById(R.id.imgTel);
            if(!StringUtils.isEmpty(clickedLibrary.getReceptionPhoneNumber()))
            {
                imgTel.setVisibility(v.VISIBLE);
                txtTel.setVisibility(v.VISIBLE);

                //PLACEMENTS
                RelativeLayout.LayoutParams lpTxt = (RelativeLayout.LayoutParams) txtTel.getLayoutParams();
                RelativeLayout.LayoutParams lpImg = (RelativeLayout.LayoutParams) imgTel.getLayoutParams();
                if(!StringUtils.isEmpty(clickedLibrary.getMail()))
                {
                    lpTxt.setMargins(240, 228, 0, 0);
                    txtTel.setLayoutParams(lpTxt);

                    lpImg.setMargins(20, 210, 0, 0);
                    imgTel.setLayoutParams(lpImg);
                }
                else
                {

                    lpTxt.setMargins(200, 45, 0, 0);
                    txtTel.setLayoutParams(lpTxt);

                    lpImg.setMargins(20, 30, 0, 0);
                    imgTel.setLayoutParams(lpImg);
                }
                txtTel.setText(clickedLibrary.getReceptionPhoneNumber());
            }
            else
            {
                txtTel.setVisibility(v.GONE);
                imgTel.setVisibility(v.GONE);
            }



            //Ajouter dynamiquement une image (email & tel)
            /*
            if(clickedLibrary.getMail() != "")
            {
                RelativeLayout simpleRelativeLayout;
                // get the reference of RelativeLayout
                simpleRelativeLayout = (RelativeLayout) v.findViewById(R.id.rl);
                // set the layout params for ImageView
                RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                // create a new ImageView
                ImageView simpleImageView = new ImageView(getActivity().getApplicationContext());
                simpleImageView.setId(1);  // set ImageView's id
                simpleImageView.setLayoutParams(imageViewParam); // set defined layout params to ImageView
                simpleImageView.setImageResource(R.drawable.aquagym);    // set resource in ImageView
                simpleImageView.setBackgroundColor(Color.BLACK); // set black color in the background of ImageView
                imageViewParam.addRule(RelativeLayout.CENTER_HORIZONTAL); // align ImageView in the center
                simpleRelativeLayout.addView(simpleImageView); // add ImageView in RelativeLayout
            }
             */

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return v;
    }

}