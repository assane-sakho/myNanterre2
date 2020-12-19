package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;
import android.os.StrictMode;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

abstract class ApiHelper<SimpleElement extends BaseDbElement, CompleteElement extends BaseDbElement> {
    protected static final String LOCALURLDEV = "http://192.168.43.209:3000/api/";
    protected static final String BASEURLDEV = "https://dev-mynanterreapi.herokuapp.com/api/";
    protected static final  String BASEURLPROD = "https://mynanterreapi.herokuapp.com/api/";
    protected static final String BASEURL = LOCALURLDEV;
    protected  Gson gson;

    private List<SimpleElement> simpleElements;
    private List<CompleteElement> completeElements;
    private boolean dataLoaded;
    private int pagesNumber;

    private String baseEndPoint;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ApiHelper(String baseEndPoint)
    {
        this.baseEndPoint = baseEndPoint;

        gson = new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) -> LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm")))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .registerTypeAdapter(byte[].class, (JsonDeserializer<byte[]>) (json, typeOfT, context) -> Base64.decode(json.getAsString(), Base64.NO_WRAP))
                .create();

        simpleElements = new ArrayList<>();
        completeElements = new ArrayList<>();
    }

    protected final String getJsonWithIdAsString(String endpoint) throws IOException {
        return getResultAsString(endpoint, "application/ld+json");
    }

    protected final String getJsonAsString(String endpoint) throws IOException {
        return getResultAsString(endpoint, "application/json");
    }

    protected final String getResultAsString(String endpoint, String header) throws IOException {
        InputStream is = null;
        try {
            final URL url = new URL(BASEURL + endpoint);
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.addRequestProperty("accept", header);
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<SimpleElement> getSimpleElements() throws ExecutionException, InterruptedException {
        if (!dataLoaded) {
            synchronized (simpleElements) {
                simpleElements.addAll(getFirstPage());
                getAllPages();

                dataLoaded = true;
            }
        }
        return simpleElements;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private List<SimpleElement> getFirstPage() {
        List<SimpleElement> simpleClubList = new ArrayList<>();

        try {
            String baseEndpointUrl = baseEndPoint + "/?page=";
            String jsonString = getJsonWithIdAsString(baseEndpointUrl + 1);
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonArray jsonMembersArray = jsonObject.getAsJsonArray("hydra:member");

            if(jsonString.contains("hydra:view") && jsonString.contains("hydra:last"))
            {
                pagesNumber = Integer.valueOf(jsonObject
                        .getAsJsonObject("hydra:view")
                        .get("hydra:last").getAsString().split("=")[1]);
            }
            else
            {
                pagesNumber = 1;
            }

            simpleClubList = convertToList(jsonMembersArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleClubList;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private List<SimpleElement> getClubsByPage(int page) {
        List<SimpleElement> simpleClubList = new ArrayList<>();

        try {
            String jsonString = getJsonAsString(baseEndPoint + "/?page=" + page);

            simpleClubList = convertToList(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleClubList;
    }

    private class ElementsCallable implements Callable<List<SimpleElement>> {
        private final Integer pageIndex;

        public ElementsCallable(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<SimpleElement> call() {
            return getClubsByPage(pageIndex);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getAllPages() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(pagesNumber);

        List<ElementsCallable> callableTasks = new ArrayList<>();

        for (int i = 2; i <= pagesNumber; i++)
            callableTasks.add(new ElementsCallable(i));

        List<Future<List<SimpleElement>>> futures = executorService.invokeAll(callableTasks);

        for (Future<List<SimpleElement>> f : futures)
            simpleElements.addAll(f.get());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CompleteElement getCompleteElement(int id) {

        synchronized (completeElements) {
            Optional<CompleteElement> optionalLibrary = completeElements.stream().filter(l -> l.getId() == id).findFirst();

            if (!optionalLibrary.isPresent()) {
                try {
                    String jsonString = getJsonAsString(baseEndPoint + "/" + id);
                    optionalLibrary = Optional.of(convertToComplete(jsonString));
                    completeElements.add(optionalLibrary.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return optionalLibrary.get();
        }
    }

    abstract List<SimpleElement> convertToList(JsonArray jsonArray);

    abstract List<SimpleElement> convertToList(String jsonString);

    abstract CompleteElement convertToComplete(String jsonString);


}