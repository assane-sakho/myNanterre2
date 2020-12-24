package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;
import miage.parisnanterre.fr.mynanterre2.implem.ListeCrous;

public class Crous extends SimpleCrous {
    private List<CrousProduct> crousProducts;
    private List<Schedule> crousSchedules;

    public List<CrousProduct> getCrousProducts() {
        return crousProducts;
    }

    public List<Schedule> getCrousSchedules() {
        return crousSchedules;
    }
}
