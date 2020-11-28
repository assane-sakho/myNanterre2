package miage.parisnanterre.fr.mynanterre.api.library;

public abstract class LibraryRelatedElement {
    protected final int id;
    protected String content;
    protected final Library library;

    public LibraryRelatedElement(int id, String content, Library library)
    {
        this.id = id;
        this.content = content;
        this.library = library;
    }

    /* GETTER */
    protected int getId()
    {
        return id;
    }

    protected String getContent()
    {
        return this.content;
    }

    protected Library getLibrary()
    {
        return library;
    }

    /* Setter */

    public void setContent(String content)
    {
        this.content = content;
    }
}
