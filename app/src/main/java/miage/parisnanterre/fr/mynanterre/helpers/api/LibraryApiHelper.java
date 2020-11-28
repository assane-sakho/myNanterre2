package miage.parisnanterre.fr.mynanterre.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.api.library.Library;

public class LibraryApiHelper extends ApiHelper {
    private static LibraryApiHelper instance = new LibraryApiHelper();
    private List<Library> libraries;
    private boolean isDataLoaded;

    // Hide default constructor
    private LibraryApiHelper(){
        libraries = new ArrayList<>();
        isDataLoaded = false;
    }

    public static LibraryApiHelper getInstance()
    {
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Library> getLibraries() {

        synchronized (libraries)
        {
            if(isDataLoaded)
                return libraries;

            try {
                String jsonString = getJsonAsString("libraries");
                libraries = Arrays.asList(gson.fromJson(jsonString, Library[].class));
                isDataLoaded = true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return libraries;
        }
    }
}
