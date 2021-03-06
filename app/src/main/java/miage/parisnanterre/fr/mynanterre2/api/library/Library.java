package miage.parisnanterre.fr.mynanterre2.api.library;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import miage.parisnanterre.fr.mynanterre2.api.building.Building;

public class Library extends SimpleLibrary{
    private String location;
    private String description;
    private String receptionPhoneNumber;
    private String mail;
    private Building building;

    @SerializedName("libraryConsultationLoanConditions")
    private List<ConsultationLoanCondition> consultationLoanConditions;

    @SerializedName("libraryDocumentaryFunds")
    private List<DocumentaryFund> documentaryFunds;

    @SerializedName("libraryServices")
    private List<Service> services;

    @SerializedName("libraryResponsables")
    private List<Responsable> responsables;

    @SerializedName("librarySchedules")
    private List<Schedule> schedules;

    @SerializedName("libraryAttendances")
    private List<Attendance> attendances;

    @SerializedName("libraryDomains")
    private List<Domain> domains;

    public Library(String name, String location, String description, String receptionPhoneNumber, String mail, Building building, List<ConsultationLoanCondition> consultationLoanConditions, List<DocumentaryFund> documentaryFunds, List<Service> services, List<Responsable> responsables, List<Schedule> schedules, List<Attendance> attendances, List<Domain> domains) {
        super(name);
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
        this.attendances = attendances;
        this.domains = domains;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
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

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
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
