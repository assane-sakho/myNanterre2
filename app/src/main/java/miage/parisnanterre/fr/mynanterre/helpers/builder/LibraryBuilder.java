package miage.parisnanterre.fr.mynanterre.helpers.builder;

import java.util.List;

import miage.parisnanterre.fr.mynanterre.api.building.Building;
import miage.parisnanterre.fr.mynanterre.api.library.*;

public class LibraryBuilder {
    private Library library;
    private static LibraryBuilder instance = new LibraryBuilder();

    // Hide default constructor
    private LibraryBuilder () { }

    public static LibraryBuilder getInstance()
    {
        return instance;
    }

    public LibraryBuilder initLibrary()
    {
        library = null;
        return this;
    }

    public LibraryBuilder setId(int id)
    {
//        library.setId(id);
        return this;
    }

    public LibraryBuilder setName(String name) {
        library.setName(name);
        return this;
    }

    public LibraryBuilder setLocation(String location) {
        library.setLocation(location);
        return this;
    }

    public LibraryBuilder setDescription(String description) {
        library.setDescription(description);
        return this;
    }

//    public LibraryBuilder setBuilding(Building building) {
//        library.setBuilding(building);
//        return this;
//    }

    public LibraryBuilder setReceptionPhoneNumber(String receptionPhoneNumber) {
        library.setReceptionPhoneNumber(receptionPhoneNumber);
        return this;
    }

    public LibraryBuilder setMail(String mail) {
        library.setMail(mail);
        return this;
    }

    public LibraryBuilder setConsultationLoanConditions(List<ConsultationLoanCondition> consultationLoanConditions)
    {
        library.setConsultationLoanConditions(consultationLoanConditions);
        return this;
    }

    public LibraryBuilder setDocumentaryFunds(List<DocumentaryFund> documentaryFunds)
    {
        library.setDocumentaryFunds(documentaryFunds);
        return this;
    }

    public LibraryBuilder setResponsables(List<Responsable> responsables)
    {
        library.setResponsables(responsables);
        return this;
    }

    public LibraryBuilder setSchedules(List<Schedule> schedules)
    {
        library.setSchedules(schedules);
        return this;
    }

    public Library getLibrary()
    {
        return library;
    }
}
