package miage.parisnanterre.fr.mynanterre2.api.db;

public abstract class BaseDbElement {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
