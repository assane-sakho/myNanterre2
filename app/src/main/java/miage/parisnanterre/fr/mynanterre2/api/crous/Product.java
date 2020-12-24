package miage.parisnanterre.fr.mynanterre2.api.crous;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;

public class Product  extends NamedDbElement {
    public Double getPrice() {
        return price;
    }

    private Double price;
}
