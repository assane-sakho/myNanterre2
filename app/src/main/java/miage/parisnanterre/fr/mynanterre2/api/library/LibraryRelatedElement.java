package miage.parisnanterre.fr.mynanterre2.api.library;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public abstract class LibraryRelatedElement extends BaseDbElement {
    protected final Library library;

    public LibraryRelatedElement(int id, Library library)
    {
        this.id = id;
        this.library = library;
    }

    /* GETTER */
    protected Library getLibrary()
    {
        return library;
    }
}
