package miage.parisnanterre.fr.mynanterre.api.library;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.api.building.Building;

public class Library {
    private Integer id;
    private String name;
    private String location;
    private String description;
    private String receptionPhoneNumber;
    private String mail;
    private Building building;

    @JsonProperty("libraryConsultationLoanConditions")
    private List<ConsultationLoanCondition> consultationLoanConditions;

    @JsonProperty("libraryDocumentaryFund")
    private List<DocumentaryFund> documentaryFunds;

    @JsonProperty("libraryService")
    private List<Service> services;

    @JsonProperty("libraryResponsables")
    private List<Responsable> responsables;

    @JsonProperty("librarySchedules")
    private List<Schedule> schedules;


    public Library(Integer id, String name, String location, String description, String receptionPhoneNumber, String mail, Building building, List<ConsultationLoanCondition> consultationLoanConditions, List<DocumentaryFund> documentaryFunds, List<Service> services, List<Responsable> responsables, List<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.receptionPhoneNumber = receptionPhoneNumber;
        this.mail = mail;
        this.building = building;
        this.consultationLoanConditions = consultationLoanConditions;
        this.documentaryFunds = documentaryFunds;
        this.services = services;
        this.responsables = responsables;
        this.schedules = schedules;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceptionPhoneNumber() {
        return receptionPhoneNumber;
    }

    public void setReceptionPhoneNumber(String receptionPhoneNumber) {
        this.receptionPhoneNumber = receptionPhoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<ConsultationLoanCondition> getConsultationLoanConditions() {
        return consultationLoanConditions;
    }

    public void setConsultationLoanConditions(List<ConsultationLoanCondition> consultationLoanConditions) {
        this.consultationLoanConditions = consultationLoanConditions;
    }

    public List<DocumentaryFund> getDocumentaryFunds() {
        return documentaryFunds;
    }

    public void setDocumentaryFunds(List<DocumentaryFund> documentaryFunds) {
        this.documentaryFunds = documentaryFunds;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addConsultationLoadCondition(ConsultationLoanCondition consultationLoanCondition)
    {
        consultationLoanConditions.add(consultationLoanCondition);
    }

    public void addDocumentaryFund(DocumentaryFund documentaryFund)
    {
        documentaryFunds.add(documentaryFund);
    }

    public void addResponsable(Responsable responsable)
    {
        responsables.add(responsable);
    }

    public void addSchedule(Schedule schedule)
    {
        schedules.add(schedule);
    }

}
