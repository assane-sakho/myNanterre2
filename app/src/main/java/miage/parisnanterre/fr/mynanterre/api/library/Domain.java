package miage.parisnanterre.fr.mynanterre.api.library;

public class Domain extends LibraryRelatedElement {
    private String name;

    public Domain(int id, String name, Library library) {
        super(id, library);
        this.name = name;
    }
}
