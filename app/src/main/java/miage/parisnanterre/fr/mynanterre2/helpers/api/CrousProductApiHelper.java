package miage.parisnanterre.fr.mynanterre2.helpers.api;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import miage.parisnanterre.fr.mynanterre2.api.club.Publication;
import miage.parisnanterre.fr.mynanterre2.api.crous.CrousProduct;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CrousProductApiHelper extends ApiHelper<CrousProduct, CrousProduct> {

    private static CrousProductApiHelper instance;
    private static final String baseFinalEndPoint = "crous_products";

    private CrousProductApiHelper() {
        super(baseFinalEndPoint, false, true, true);
    }

    public static CrousProductApiHelper getInstance()
    {
        if(instance == null)
            instance = new CrousProductApiHelper();
        return instance;
    }

    @Override
    List<CrousProduct> convertToList(JsonArray jsonArray) {
        return Arrays.asList(gson.fromJson(jsonArray, CrousProduct[].class));
    }

    @Override
    List<CrousProduct> convertToList(String jsonString) {
        return Arrays.asList(gson.fromJson(jsonString, CrousProduct[].class));
    }

    @Override
    CrousProduct convertToComplete(String jsonString) {
        return gson.fromJson(jsonString, CrousProduct.class);
    }

    public List<CrousProduct> getAllCrousProduct(int crousId) throws ExecutionException, InterruptedException {
        baseEndpointUrl = baseFinalEndPoint + "?crous=" + crousId;
        return getAllSimpleElements();
    }
}
