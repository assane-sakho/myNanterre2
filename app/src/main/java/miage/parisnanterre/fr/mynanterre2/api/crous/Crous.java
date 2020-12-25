package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.util.ArrayList;
import java.util.List;

public class Crous extends SimpleCrous{
    private List<CrousProduct> crousProducts;

    public Crous()
    {
        crousProducts = new ArrayList();
    }

    public List<CrousProduct> getCrousProducts() {
        return crousProducts;
    }

    public void setCrousProducts(List<CrousProduct> crousProducts) {
        this.crousProducts = crousProducts;
    }
}
