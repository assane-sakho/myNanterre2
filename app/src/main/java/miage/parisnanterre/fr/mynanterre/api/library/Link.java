package miage.parisnanterre.fr.mynanterre.api.library;

public class Link extends LibraryRelatedElement {
    private String url;

    public Link(int id, String url, Library library) {
        super(id, library);
        this.url = url;
    }
}
