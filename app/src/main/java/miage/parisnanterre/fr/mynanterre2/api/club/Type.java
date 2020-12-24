package miage.parisnanterre.fr.mynanterre2.api.club;

import miage.parisnanterre.fr.mynanterre2.api.db.NamedDbElement;

public class Type extends NamedDbElement {
    public Type(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
