package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;

@RequiresApi(api = Build.VERSION_CODES.O)
public class LibraryApiHelper extends ApiHelper<SimpleLibrary, Library> {

    private static LibraryApiHelper instance;
    private static String baseEndPoint = "libraries";

    private LibraryApiHelper() {
        super(baseEndPoint, true);
    }

    public static LibraryApiHelper getInstance()
    {
        if(instance == null)
            instance = new LibraryApiHelper();
        return instance;
    }

    @Override
    List<SimpleLibrary> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, SimpleLibrary[].class));
    }

    @Override
    List<SimpleLibrary> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, SimpleLibrary[].class));
    }

    @Override
    Library convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, Library.class);
    }

    public List<SimpleLibrary> getAllSimpleLibraries() throws ExecutionException, InterruptedException {
        return getAllSimpleElements();
    }

    public Library getLibrary(int id) {
        return getCompleteElement(id);
    }
}
