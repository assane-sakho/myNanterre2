package miage.parisnanterre.fr.mynanterre2.api.crous;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.LocalTime;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class ProductAvailability extends BaseDbElement {
    private boolean isAvailable;
    private LocalDateTime date;
    private CrousProduct crousProduct;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ProductAvailability(boolean isAvailable, CrousProduct crousProduct) {
        this.isAvailable = isAvailable;
        this.crousProduct = crousProduct;
        this.date=LocalDateTime.now();
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public CrousProduct getCrousProduct() {
        return crousProduct;
    }

    public void setCrousProduct(CrousProduct crousProduct) {
        this.crousProduct = crousProduct;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
