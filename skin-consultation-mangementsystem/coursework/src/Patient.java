//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898888
//Date: 25/12/2022

import java.time.LocalDate;
import java.time.LocalTime;

public class Patient extends Person {
    private String patientId;        //Declaring the attributes


    //creating the patient constructor

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String mobNo,String patientId) {
        super(firstName, lastName, dateOfBirth, mobNo);

            this.patientId = patientId ;

    }

    @Override
    public String toString() {
        return "Patient[patientId=" + patientId + ", firstName=" + getFirstName() + ", lastName=" + getLastname()
                + ", dateOfBirth=" + getDateOfBirth() + ", mobNo=" + getMobNo() + "]";
    }


    public String getPatientId() {
        return patientId;

    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;

    }


}
