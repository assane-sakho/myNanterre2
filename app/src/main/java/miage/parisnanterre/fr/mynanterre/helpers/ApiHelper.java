package miage.parisnanterre.fr.mynanterre.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiHelper {
    private static final String BASEURLDEV = "https://dev-mynanterreapi.herokuapp.com/index.php/api/";
    private static final  String BASEURLPROD = "https://mynanterreapi.herokuapp.com/index.php/api/";
    private static final String BASEURL = BASEURLPROD;

    private static ApiHelper instance = new ApiHelper();

    // Hide default constructor
    private ApiHelper(){ }

    public static ApiHelper getInstance()
    {
        return instance;
    }

    public List<String> getCategorieSport() throws IOException, JSONException {
        return getJsonAsStringList("getCategorieSport", Arrays.asList("categorie"));
    }

    private String getJsonAsString(String url) throws IOException {
        InputStream is = null;
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL(BASEURL + url).openConnection();
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            is = conn.getInputStream();
            // Read the InputStream and save it in a string
            return readIt(is);
        } finally {
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
            if (is != null) {
                is.close();
            }
        }
    }

    private List<String> getJsonAsStringList(String url, List<String> keys) throws IOException, JSONException {
        List<String> result = new ArrayList<>();

        String jsonResult = getJsonAsString(url);
        JSONArray jsonArray = new JSONArray(jsonResult);

        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject j = new JSONObject(jsonArray.getString(i));
            for(String key : keys)
                result.add(j.getString(key));
        }

        return result;
    }

    private String readIt(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            response.append(line).append('\n');
        }
        return response.toString();
    }

}
