package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;

public class InformationFragment extends Fragment {

    View v;
    private Library clickedLibrary;
    public InformationFragment() {
        // Required empty public constructor
    }

    public InformationFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.information_bu_view, container, false);

        try {

            //BU Name

            TextView txtview = v.findViewById(R.id.NameBU);
            txtview.setText(clickedLibrary.getName());


            TextView txtEmail = v.findViewById(R.id.txtEmail);
            TextView txtTel = v.findViewById(R.id.txtTel);

            ImageView imgEmail = v.findViewById(R.id.imgMail);
            if(StringUtils.isEmpty(clickedLibrary.getMail()))
            {
                imgEmail.setVisibility(v.GONE);
            }

            ImageView imgTel = v.findViewById(R.id.imgTel);
            if(StringUtils.isEmpty(clickedLibrary.getReceptionPhoneNumber()))
            {
                imgTel.setVisibility(v.GONE);
            }
            txtTel.setText(clickedLibrary.getReceptionPhoneNumber());
            txtEmail.setText(clickedLibrary.getMail());


            //Description
            TextView txtDesc = v.findViewById(R.id.txtDescription);
            txtDesc.setText(clickedLibrary.getDescription());


            //EMAIL

            /*
            TextView txtEmail = v.findViewById(R.id.email);
            ImageView imgEmail = v.findViewById(R.id.imgMail);

            if(!StringUtils.isEmpty(clickedLibrary.getMail()))
            {
                txtEmail.setText(clickedLibrary.getMail());


                imgEmail.setVisibility(v.VISIBLE);
                txtEmail.setVisibility(v.VISIBLE);
            }
            else
            {
                imgEmail.setVisibility(v.GONE);
                txtEmail.setVisibility(v.GONE);
            }

            //TELEPHONE

            TextView txtTel = v.findViewById(R.id.txtTel);
            ImageView imgTel = v.findViewById(R.id.imgTel);
            if(!StringUtils.isEmpty(clickedLibrary.getReceptionPhoneNumber()))
            {
                imgTel.setVisibility(v.VISIBLE);
                txtTel.setVisibility(v.VISIBLE);

                txtTel.setText(clickedLibrary.getReceptionPhoneNumber());
            }
            else
            {
                imgTel.setVisibility(v.GONE);
                txtTel.setVisibility(v.GONE);
            }

             */


            /*
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

                    lpTxt.setMargins(80, 530, 10, 0);
                    txtTel.setLayoutParams(lpTxt);

                    lpImg.setMargins(10, 530, 0, 0);
                    imgTel.setLayoutParams(lpImg);
                }
                txtTel.setText(clickedLibrary.getReceptionPhoneNumber());
            }
            else
            {
                txtTel.setVisibility(v.GONE);
                imgTel.setVisibility(v.GONE);
            }


             */
























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
        catch(Exception e)
        {
            e.getStackTrace();
        }


        return v;
    }

}