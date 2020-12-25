package miage.parisnanterre.fr.mynanterre2.api.db;

import java.util.Objects;

public abstract class  NamedDbElement extends BaseDbElement {
    protected String name;

    public NamedDbElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedDbElement that = (NamedDbElement) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
