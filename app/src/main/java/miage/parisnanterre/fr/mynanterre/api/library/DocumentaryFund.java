package miage.parisnanterre.fr.mynanterre.api.library;

public class DocumentaryFund  extends LibraryRelatedElement{
    public DocumentaryFund(int id, String content, Library library) {
        super(id, content, library);
    }

    public String getContent()
    {
        return this.content;
    }
}
