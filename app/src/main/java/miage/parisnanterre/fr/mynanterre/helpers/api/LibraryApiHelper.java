package miage.parisnanterre.fr.mynanterre.helpers.api;

import android.content.Context;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import miage.parisnanterre.fr.mynanterre.api.library.Library;
import miage.parisnanterre.fr.mynanterre.helpers.builder.LibraryBuilder;

public class LibraryApiHelper extends ApiHelper {
    private static LibraryApiHelper instance = new LibraryApiHelper();
    private LibraryBuilder libraryBuilder;

    // Hide default constructor
    private LibraryApiHelper(){
        libraryBuilder = LibraryBuilder.getInstance();
    }

    public static LibraryApiHelper getInstance()
    {
        return instance;
    }

    public List<Library> getLibraries() throws IOException {
        List<Library> libraries = new ArrayList<>();
        try {
            String jsonString = getJsonAsString("libraries");
            ObjectMapper mapper = new ObjectMapper();

//           JSONObject jsonObject = new JSONObject(jsonString);
            Gson gson = new Gson();
            libraries = Arrays.asList(gson.fromJson(jsonString, Library[].class));
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       return libraries;
    }

}
