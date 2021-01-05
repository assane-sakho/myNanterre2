package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.stream.Collectors;

import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.api.library.ConsultationLoanCondition;
import miage.parisnanterre.fr.mynanterre2.api.library.DocumentaryFund;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.Service;

public class ConditionPretFragment extends Fragment {

    private View v;
    private Library clickedLibrary;

    public ConditionPretFragment(){}
    public ConditionPretFragment(Library clickedLibrary)
    {
        this.clickedLibrary = clickedLibrary;
    }

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.condition_pret_view, container, false);

        TextView txtCond = v.findViewById(R.id.txtConditionPret);

        //List<String> conditions = clickedLibrary.getConsultationLoanConditions().stream().map(c -> c.getName()).collect(Collectors.toList());
        txtCond.setText(clickedLibrary.getConsultationLoanConditions().stream().map(ConsultationLoanCondition::getName).collect(Collectors.joining("\n")));

        TextView txtDocDispo = v.findViewById(R.id.DocDispo);
        txtDocDispo.setText(clickedLibrary.getDocumentaryFunds().stream().map(DocumentaryFund::getName).collect(Collectors.joining("\n")));

        TextView MatDispo = v.findViewById(R.id.MatDispo);
        MatDispo.setText(clickedLibrary.getServices().stream().map(Service::getName).collect(Collectors.joining("\n")));

        return v;
    }


}
