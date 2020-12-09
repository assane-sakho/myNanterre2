package miage.parisnanterre.fr.mynanterre2.api.library;

public class Responsable extends LibraryRelatedElement {
    private String fullName;
    private String phoneNumber;
    private String mail;

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public Responsable(int id, String fullName, String phoneNumber, String mail, Library library) {
        super(id, library);
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

}
