package miage.parisnanterre.fr.mynanterre.api.library;

public class Responsable extends LibraryRelatedElement {
    private String phoneNumber;
    private String mail;

    public Responsable(int id, String content, Library library) {
        super(id, content, library);
    }

}
