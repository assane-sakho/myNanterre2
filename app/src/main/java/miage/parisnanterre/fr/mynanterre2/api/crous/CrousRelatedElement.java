package miage.parisnanterre.fr.mynanterre2.api.crous;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class CrousRelatedElement extends BaseDbElement {
    protected Crous crous;

    public CrousRelatedElement(Crous crous)
    {
        this.crous = crous;
    }

    public Crous getCrous() {
        return crous;
    }

    public void setCrous(Crous crous) {
        this.crous = crous;
    }
}
