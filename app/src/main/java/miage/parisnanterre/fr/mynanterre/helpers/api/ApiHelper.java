package miage.parisnanterre.fr.mynanterre.helpers.api;

import android.os.Build;
import android.os.StrictMode;

import androidx.annotation.RequiresApi;

import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        gson = new GsonBuilder().registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

                return LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm")); }

        }).create();
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