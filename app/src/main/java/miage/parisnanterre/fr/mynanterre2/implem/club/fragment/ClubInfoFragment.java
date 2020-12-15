package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.club.viewModel.ClubInfoViewModel;


public class ClubInfoFragment extends Fragment {

    private ClubInfoViewModel mViewModel;

    public static ClubInfoFragment newInstance() {
        return new ClubInfoFragment();
    }

    ImageView img;
    TextView nom, cat, creator, desc, date;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.club_info_fragment, container, false);
        /*img=(ImageView)findViewById(R.id.imageClub);
        nom=(TextView) v.findViewById(R.id.nomClub);
        cat=(TextView)findViewById(R.id.catClub);
        creator=(TextView)findViewById(R.id.creatorClub);
        desc=(TextView)findViewById(R.id.descClub);
        date=(TextView)findViewById(R.id.dateClub);

        Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
        img.setImageBitmap(bitmap);
        nom.setText(getIntent().getStringExtra("nom"));
        cat.setText(getIntent().getStringExtra("cat"));
        creator.setText(getIntent().getStringExtra("creator"));
        desc.setText(getIntent().getStringExtra("desc"));
        date.setText(getIntent().getStringExtra("date"));

        if(!getIntent().getBooleanExtra("certified", true)){
            findViewById(R.id.certif).setVisibility(View.INVISIBLE);
        }*/

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ClubInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}