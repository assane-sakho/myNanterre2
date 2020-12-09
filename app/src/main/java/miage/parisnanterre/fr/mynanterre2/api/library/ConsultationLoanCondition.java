package miage.parisnanterre.fr.mynanterre2.api.library;

public class ConsultationLoanCondition extends LibraryRelatedElement  {
    private String name;

    public ConsultationLoanCondition(int id, String condition, Library library) {
        super(id, library);
        this.name = condition;
    }
}
