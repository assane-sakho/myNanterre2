package miage.parisnanterre.fr.mynanterre2.api.db;

import android.os.Build;

import androidx.annotation.RequiresApi;

import miage.parisnanterre.fr.mynanterre2.helpers.api.ApiHelper;

public abstract class BaseDbElement {
    protected int id;

    public int getId() {
        return id;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getUri() {

        String baseEndPoint = ApiHelper.childrenBaseEndpoint.get(this.getClass());

        return "/api/" + baseEndPoint + "/" + id;
    }
}
