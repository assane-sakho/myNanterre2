package miage.parisnanterre.fr.mynanterre.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.helpers.api.LibraryApiHelper;
import miage.parisnanterre.fr.mynanterre.implem.library.ListeEspacesBu;


public class BiblioFragment extends Fragment {
    private WebView mWebView;
    private LibraryApiHelper libraryApiHelper;
    private View v;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.biblio, container, false);

        libraryApiHelper = LibraryApiHelper.getInstance();
        GetLibrariesAsync getLibrariesAsync = new GetLibrariesAsync();
        getLibrariesAsync.execute();

        mWebView = v.findViewById(R.id.webview);
        mWebView.loadUrl("http://umap.openstreetmap.fr/fr/map/bibliotheque-de-luniversite-paris-nanterre_222181#17/48.90458/2.21537");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        Button frequentationBtn = v.findViewById(R.id.btnFrequentation);
        frequentationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListeEspacesBu.class));
            }
        });

        return v;
    }
    private final class GetLibrariesAsync extends AsyncTask<Void, Void, String> {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(Void... params) {
            libraryApiHelper.getLibraries();

            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Button frequentationBtn = v.findViewById(R.id.btnFrequentation);
            frequentationBtn.setText("Infos. bibliothèques");
        }
    }

}