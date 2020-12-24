package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class CrousProduct  extends BaseDbElement {
    private Crous crous;
    private Product product;
    private List<ProductAvailability> productAvailabilities;

    public Product getProduct() {
        return product;
    }

    public List<ProductAvailability> getProductAvailabilities() {
        return productAvailabilities;
    }
}
