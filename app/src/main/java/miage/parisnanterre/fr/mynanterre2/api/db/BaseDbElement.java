package miage.parisnanterre.fr.mynanterre2.api.db;

import java.util.Objects;

public abstract class BaseDbElement {
    protected transient int id;

    public BaseDbElement()
    {
        id = 0;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDbElement that = (BaseDbElement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
