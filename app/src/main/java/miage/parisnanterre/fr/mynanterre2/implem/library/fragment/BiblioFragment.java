package miage.parisnanterre.fr.mynanterre2.implem.library.fragment;

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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.helpers.api.LibraryApiHelper;
import miage.parisnanterre.fr.mynanterre2.implem.library.ListeEspacesBu;


public class BiblioFragment extends Fragment {
    private WebView mWebView;
    private LibraryApiHelper libraryApiHelper;
    private View v;

    public static BiblioFragment newInstance() {
        return new BiblioFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.biblio_fragment, container, false);

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

        Button btnLibrariesInfos = v.findViewById(R.id.btnLibrariesInfos);
        btnLibrariesInfos.setOnClickListener(new View.OnClickListener() {
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
            libraryApiHelper.getSimpleLibraries();

            return "executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Button btnLibrariesInfos = v.findViewById(R.id.btnLibrariesInfos);
            btnLibrariesInfos.setText("Infos. bibliothèques");
        }
    }

}