package miage.parisnanterre.fr.mynanterre.api.library;

public class DocumentaryFund  extends LibraryRelatedElement{
    private String name;

    public DocumentaryFund(int id, String name, Library library) {
        super(id, library);
        this.name = name;
    }

}
