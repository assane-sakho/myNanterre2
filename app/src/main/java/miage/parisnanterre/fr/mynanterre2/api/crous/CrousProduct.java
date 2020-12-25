package miage.parisnanterre.fr.mynanterre2.api.crous;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class CrousProduct  extends CrousRelatedElement {
    private Product product;
    private List<ProductAvailability> productAvailabilities;

    public CrousProduct(Crous crous, Product product) {
        super(crous);
        this.product = product;
        productAvailabilities = new ArrayList();
    }

    public Product getProduct() {
        return product;
    }

    public void addProductAvailabilities(ProductAvailability productAvailability) {
        this.productAvailabilities.add(productAvailability);
    }

    public void setProductAvailabilities(List<ProductAvailability> productAvailabilities) {
        this.productAvailabilities = productAvailabilities;
    }

    public List<ProductAvailability> getProductAvailabilities() {
        return productAvailabilities;
    }
}
