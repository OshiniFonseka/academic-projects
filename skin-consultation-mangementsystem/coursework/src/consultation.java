//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898888
//Date: 25/12/2022

import java.time.LocalDate;
import java.time.LocalTime;


public class consultation extends Person {
    public LocalDate date;
    public LocalTime time;
    public String notes;
    public Double cost;

    public String LicenseNumber;



    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        LicenseNumber = licenseNumber;
    }

    public consultation(String firstName, String lastName, LocalDate dateOfBirth, String mobNo, LocalDate date, LocalTime time, String licenseNumber, String notes, Double cost) {
        super(firstName, lastName, dateOfBirth, mobNo);

        this.date = date;
        this.time = time;
        this.notes = notes;
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}


