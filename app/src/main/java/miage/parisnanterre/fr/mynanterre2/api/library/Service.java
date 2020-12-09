package miage.parisnanterre.fr.mynanterre2.api.library;

public class Service extends LibraryRelatedElement {
    private String name;

    public Service(int id, String name, Library library) {
        super(id, library);
        this.name = name;
    }

}
