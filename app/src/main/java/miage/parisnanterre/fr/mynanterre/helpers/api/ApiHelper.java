package miage.parisnanterre.fr.mynanterre.helpers.api;

import android.os.StrictMode;

import com.google.android.gms.common.api.Api;

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

abstract class ApiHelper {
    protected static final String LOCALURLDEV = "https://localhost:3000/index.php/api/";
    protected static final String BASEURLDEV = "https://dev-mynanterreapi.herokuapp.com/api/";
    protected static final  String BASEURLPROD = "https://mynanterreapi.herokuapp.com/index.php/api/";
    protected static final String BASEURL = BASEURLDEV;

    public ApiHelper()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    protected final String getJsonAsString(String endpoint) throws IOException {
        InputStream is = null;
        try {
            final URL url = new URL(BASEURL + endpoint);
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.addRequestProperty("accept", "application/json");
            conn.connect();
            is = conn.getInputStream();
            String response = readIt(is);
            return response;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return  "";
        }
        finally {
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
            if (is != null) {
                is.close();
            }
        }
    }

    protected final List<String> getJsonAsStringList(String url, List<String> keys) throws IOException, JSONException {
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