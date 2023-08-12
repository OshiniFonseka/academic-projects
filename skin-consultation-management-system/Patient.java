package oopcw;

import java.time.LocalDate;

public class Patient extends Person {
    private String patientId;

    //creating the constructor
    public Patient(String name, String surname, LocalDate dateOfBirth, String contact, String patientId){
        super(name, surname, dateOfBirth, contact);
        this.patientId = patientId;
    }
    
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }
}