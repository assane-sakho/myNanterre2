package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;
import miage.parisnanterre.fr.mynanterre2.api.library.Library;
import miage.parisnanterre.fr.mynanterre2.api.library.SimpleLibrary;

public class LibraryApiHelper extends ApiHelper {
    private static LibraryApiHelper instance = new LibraryApiHelper();
    private List<SimpleLibrary> simpleLibraries;
    private boolean isSimpleLibrariesDataLoaded;
    private List<Library> libraries;

    // Hide default constructor
    private LibraryApiHelper() {
        simpleLibraries = new ArrayList<>();
        libraries = new ArrayList<>();
        isSimpleLibrariesDataLoaded = false;
    }

    public static LibraryApiHelper getInstance() {
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<SimpleLibrary> getSimpleLibraries() {

        synchronized (simpleLibraries) {
            if (isSimpleLibrariesDataLoaded)
                return simpleLibraries;

            try {
                String jsonString = getJsonAsString("libraries");
                simpleLibraries = Arrays.asList(gson.fromJson(jsonString, SimpleLibrary[].class));
                isSimpleLibrariesDataLoaded = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return simpleLibraries;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Library getLibrary(int id) {

        synchronized (libraries) {
            Optional<Library> optionalLibrary = libraries.stream().filter(l -> l.getId() == id).findFirst();

            if (!optionalLibrary.isPresent()) {
                try {
                    String jsonString = getJsonAsString("libraries/" + id);
                    optionalLibrary = Optional.of(gson.fromJson(jsonString, Library.class));
                    libraries.add(optionalLibrary.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return optionalLibrary.get();
        }
    }

}
