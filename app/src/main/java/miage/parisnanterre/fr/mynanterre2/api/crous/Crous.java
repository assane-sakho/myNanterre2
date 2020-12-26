package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.util.ArrayList;
import java.util.List;

public class Crous extends SimpleCrous{
    private List<CrousProduct> crousProducts;

    public Crous()
    {
        crousProducts = new ArrayList();
    }

    public Crous(SimpleCrous simpleCrous) {
        id = simpleCrous.getId();
        location = simpleCrous.getLocation();
        name = simpleCrous.getName();
        crousAttendances = simpleCrous.getCrousAttendances();
        crousSchedules = simpleCrous.getCrousSchedules();
        crousProducts = new ArrayList();
    }

    public List<CrousProduct> getCrousProducts() {
        return crousProducts;
    }

    public void setCrousProducts(List<CrousProduct> crousProducts) {
        this.crousProducts = crousProducts;
    }
}
