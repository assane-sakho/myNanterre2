package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;
import android.os.StrictMode;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

abstract class ApiHelper {
    protected static final String LOCALURLDEV = "https://localhost:3000/index.php/api/";
    protected static final String BASEURLDEV = "https://dev-mynanterreapi.herokuapp.com/api/";
    protected static final  String BASEURLPROD = "https://mynanterreapi.herokuapp.com/index.php/api/";
    protected static final String BASEURL = BASEURLDEV;
    protected  Gson gson;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ApiHelper()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        gson = new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) -> LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm")))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .registerTypeAdapter(byte[].class, (JsonDeserializer<byte[]>) (json, typeOfT, context) -> Base64.decode(json.getAsString(), Base64.NO_WRAP))
                .create();
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
            return readIt(is);
        }
        finally {
            if (is != null) {
                is.close();
            }
        }
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