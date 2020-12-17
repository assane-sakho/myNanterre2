package miage.parisnanterre.fr.mynanterre2.api.library;

public abstract class LibraryRelatedElement {
    protected final int id;
    protected final Library library;

    public LibraryRelatedElement(int id, Library library)
    {
        this.id = id;
        this.library = library;
    }

    /* GETTER */
    protected int getId()
    {
        return id;
    }

    protected Library getLibrary()
    {
        return library;
    }
}
