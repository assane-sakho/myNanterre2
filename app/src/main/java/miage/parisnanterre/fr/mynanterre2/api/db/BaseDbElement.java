package miage.parisnanterre.fr.mynanterre2.api.db;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

import miage.parisnanterre.fr.mynanterre2.helpers.api.ApiHelper;

public abstract class BaseDbElement {
    protected int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDbElement that = (BaseDbElement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getUri() {

        String baseEndPoint = ApiHelper.childrenBaseEndpoint.get(this.getClass());

        return "/api/" + baseEndPoint + "/" + id;
    }
}
