package miage.parisnanterre.fr.mynanterre2.api.building;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;

public class Building extends NamedDbElement {
    private String alias;

    public Building(String name, String alias) {
        super(name);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
