package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.annotations.Expose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import miage.parisnanterre.fr.mynanterre2.api.club.Club;
import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.club.SimpleClub;
import miage.parisnanterre.fr.mynanterre2.api.crous.Attendance;
import miage.parisnanterre.fr.mynanterre2.api.crous.Crous;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;
import miage.parisnanterre.fr.mynanterre2.api.crous.ProductAvailability;
import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;
import miage.parisnanterre.fr.mynanterre2.api.user.User;
import miage.parisnanterre.fr.mynanterre2.api.user.UserClub;
import miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter.JsonClubAdapter;
import miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter.JsonClubPublicationAdapter;
import miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter.JsonCrousAttendanceAdapter;
import miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter.JsonProductAvailabilityAdapter;
import miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter.JsonUserAdapter;
import miage.parisnanterre.fr.mynanterre2.helpers.jsonAdapter.JsonUserClubAdapter;

@RequiresApi(api = Build.VERSION_CODES.O)
public abstract class ApiHelper<SimpleElement extends BaseDbElement, CompleteElement extends BaseDbElement> {
    private static final String LOCALURLDEV = "http://43ade1f86061.ngrok.io/api/";
    private static final String BASEURLDEV = "https://dev-mynanterreapi.herokuapp.com/api/";
    private static final  String BASEURLPROD = "https://mynanterreapi.herokuapp.com/api/";
    private static final String BASEURL = BASEURLDEV;
    protected  Gson gson;

    protected List<SimpleElement> simpleElements;
    protected List<CompleteElement> completeElements;
    protected boolean dataLoadedOnce;
    protected boolean refreshSimpleElementsEveryCall;
    protected boolean endPointContainsParameters;
    protected boolean hasPagination;
    protected int pagesNumber;
    protected int pageIndex;

    protected String baseEndpointUrl;
    protected char parametersCompleter;

    public final static Map<Type, String> childrenBaseEndpoint = new HashMap<Type, String>()
    {
        {
            put(SimpleClub.class, "clubs");
            put(Club.class, "clubs");
            put(Publication.class, "club_publications");
            put(miage.parisnanterre.fr.mynanterre2.api.club.Type.class, "club_types");
            put(SimpleLibrary.class, "libraries");
            put(Library.class, "libraries");
            put(miage.parisnanterre.fr.mynanterre2.api.user.User.class, "users");
            put(Crous.class, "crouses");
            put(Attendance.class, "crous_attendances");
            put(CrousProduct.class, "crous_products");
        }
    };
    public ApiHelper(String baseEndpointUrl, boolean hasPagination)
    {
        this.baseEndpointUrl = baseEndpointUrl;
        this.refreshSimpleElementsEveryCall = false;
        this.hasPagination = hasPagination;
        endPointContainsParameters = false;

        instantiateParameters();
    }

    public ApiHelper(String baseEndpointUrl, boolean hasPagination, boolean refreshSimpleElementsEveryCall, boolean endPointContainsParameters)
    {
        this.baseEndpointUrl = baseEndpointUrl;

        this.hasPagination = hasPagination;
        this.refreshSimpleElementsEveryCall = refreshSimpleElementsEveryCall;
        this.endPointContainsParameters = endPointContainsParameters;

        instantiateParameters();
    }

    private final void instantiateParameters()
    {
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) -> LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm")))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) -> LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .registerTypeAdapter(byte[].class, (JsonDeserializer<byte[]>) (json, typeOfT, context) -> Base64.decode(json.getAsString(), Base64.NO_WRAP))
                .registerTypeAdapter(Club.class, new JsonClubAdapter())
                .registerTypeAdapter(Publication.class, new JsonClubPublicationAdapter())
                .registerTypeAdapter(Attendance.class, new JsonCrousAttendanceAdapter())
                .registerTypeAdapter(ProductAvailability.class, new JsonProductAvailabilityAdapter())
                .registerTypeAdapter(UserClub.class, new JsonUserClubAdapter())
                .registerTypeAdapter(User.class, new JsonUserAdapter())
                .create();

        simpleElements = new ArrayList<>();
        completeElements = new ArrayList<>();

        parametersCompleter = endPointContainsParameters ? '&' : '?';

        dataLoadedOnce = false;
        pageIndex = 1;
    }

    private final String readIt(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            response.append(line).append('\n');
        }
        return response.toString();
    }

    public final void resetPaginationIndex()
    {
        pageIndex = 1;
    }

    abstract List<SimpleElement> convertToList(JsonArray jsonArray);

    abstract List<SimpleElement> convertToList(String jsonString);

    abstract CompleteElement convertToComplete(String jsonString);

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
            String token = LoginApiHelper.getInstance().getUserToken();
            conn.setRequestProperty("Authorization", "Bearer "+  token);
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

    protected SimpleElement getSimpleElement(int id) {
        synchronized (simpleElements) {

            return simpleElements.stream().filter(l -> l.getId() == id).findFirst().get();
        }
    }

    protected CompleteElement getCompleteElement(int id) {

        synchronized (completeElements) {
            Optional<CompleteElement> optionalLibrary = completeElements.stream().filter(l -> l.getId() == id).findFirst();

            if (!optionalLibrary.isPresent()) {
                try {
                    String jsonString = getJsonAsString(baseEndpointUrl + "/" + id);
                    optionalLibrary = Optional.of(convertToComplete(jsonString));
                    completeElements.add(optionalLibrary.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return optionalLibrary.get();
        }
    }

    protected List<SimpleElement> getAllSimpleElements() throws ExecutionException, InterruptedException {
        if (refreshSimpleElementsEveryCall || !dataLoadedOnce) {
            synchronized (simpleElements) {
                simpleElements.clear();
                if(hasPagination)
                {
                    simpleElements.addAll(getFirstPage());
                    getAllPages();
                }
                else
                {
                    simpleElements.addAll(getSimpleElements());
                }

                dataLoadedOnce = true;
            }
        }
        return simpleElements;
    }

    private List<SimpleElement> getSimpleElements() {
        List<SimpleElement> simpleElementsList = new ArrayList<>();

        try {
            String jsonString = getJsonAsString(baseEndpointUrl);

            simpleElementsList = convertToList(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleElementsList;
    }

    private List<SimpleElement> getFirstPage() {
        List<SimpleElement> simpleElementsList = new ArrayList<>();

        try {
            String jsonString = getJsonWithIdAsString(baseEndpointUrl + parametersCompleter + "page=" + 1);
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonArray jsonMembersArray = jsonObject.getAsJsonArray("hydra:member");

            if(jsonString.contains("hydra:view") && jsonString.contains("hydra:last"))
            {
                pagesNumber = Integer.valueOf(jsonObject
                        .getAsJsonObject("hydra:view")
                        .get("hydra:last").getAsString().split("page=")[1]);
            }
            else
            {
                pagesNumber = 1;
            }

            simpleElementsList = convertToList(jsonMembersArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleElementsList;
    }

    private List<SimpleElement> getClubsByPage(int page) {
        List<SimpleElement> simpleClubList = new ArrayList<>();

        try {
            String jsonString = getJsonAsString(baseEndpointUrl + parametersCompleter + "page=" + page);

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

        public List<SimpleElement> call() {
            return getClubsByPage(pageIndex);
        }
    }

    private void getAllPages() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(pagesNumber);

        List<ElementsCallable> callableTasks = new ArrayList<>();

        for (int i = 2; i <= pagesNumber; i++)
            callableTasks.add(new ElementsCallable(i));

        List<Future<List<SimpleElement>>> futures = executorService.invokeAll(callableTasks);

        for (Future<List<SimpleElement>> f : futures)
            simpleElements.addAll(f.get());
    }

    protected List<SimpleElement> getMoreSimpleElements()
    {
        List<SimpleElement> simpleElementsList = new ArrayList<>();

        if(pageIndex <= pagesNumber || pagesNumber == 0)
        {
            if(pageIndex == 1)
                simpleElementsList =  getFirstPage();
            else
                simpleElementsList = getClubsByPage(pageIndex);

            pageIndex ++;

            simpleElements.addAll(simpleElementsList);
        }

        return simpleElementsList;
    }

    protected String sendData(String jsonString, ApiRequestMethod requestMethod, Optional<Integer> id) throws IOException {
        InputStream is = null;
        try {
            final URL url = new URL(BASEURL + baseEndpointUrl + (id.isPresent()? "/" + id.get() : ""));
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(requestMethod.name());

            String token = LoginApiHelper.getInstance().getUserToken();
            conn.setRequestProperty("Authorization", "Bearer "+  token);

            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            OutputStream os = conn.getOutputStream();
            os.write(jsonString.getBytes("UTF-8"));
            os.close();

            is = conn.getInputStream();
           return readIt(is);
        }
        finally {
            if (is != null) {
                is.close();
            }
        }
    }

    protected String sendData(String jsonString, ApiRequestMethod requestMethod) throws IOException {
      return sendData(jsonString, requestMethod, Optional.empty());
    }
}