package miage.parisnanterre.fr.mynanterre2.api.db;

public abstract class BaseDbElement {
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
