package miage.parisnanterre.fr.mynanterre2.implem.club.fragment;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.helpers.api.ClubApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.club.ClubActivity;
import miage.parisnanterre.fr.mynanterre2.implem.club.viewModel.ClubInfoViewModel;
import miage.parisnanterre.fr.mynanterre2.implem.library.BiblioActivity;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubInfoFragment extends Fragment {

    private ClubInfoViewModel mViewModel;
    private ImageView img;
    private TextView nom, cat, creator, desc, date, titre;
    private View v;
    private Club club;

    private ClubApiHelper clubApiHelper;

    public ClubInfoFragment(int simpleClubId){
        this.clubApiHelper = ClubApiHelper.getInstance();
        SimpleClub simpleClub = clubApiHelper.getSimpleClub(simpleClubId);
        club = new Club(simpleClub);
    }

    public static ClubInfoFragment newInstance(int simpleClubId) {
        return new ClubInfoFragment(simpleClubId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.club_info_fragment, container, false);

        titre = (TextView) v.findViewById(R.id.Title);
        img=(ImageView)v.findViewById(R.id.imageClub);
        nom=(TextView) v.findViewById(R.id.nomClub);
        cat=(TextView)v.findViewById(R.id.catClub);
        creator=(TextView)v.findViewById(R.id.creatorClub);
        desc=(TextView)v.findViewById(R.id.descClub);
        date=(TextView)v.findViewById(R.id.dateClub);

        titre.setText("Clubs");
        Bitmap bitmap = BitmapFactory.decodeByteArray(club.getImage(), 0, club.getImage().length);
        img.setImageBitmap(bitmap);
        nom.setText(club.getName());
        cat.setText("Catégorie : "+club.getType().getName());
        creator.setText("Président(e) : "+ club.getCreator().getFullName());
        desc.setText(club.getDescription());
        date.setText("Date de création : "+club.getCreationDate());

        if(club.isCertificate() == false){
            v.findViewById(R.id.certif).setVisibility(View.INVISIBLE);
        }

        ImageView back = v.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ClubActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ClubInfoViewModel.class);
        // TODO: Use the ViewModel
    }
}