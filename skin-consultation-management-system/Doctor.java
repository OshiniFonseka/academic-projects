package oopcw;

import java.time.LocalDate;

public class Doctor extends Person{
    private String licenseNumber;
    private String dSpecialisation;

    //creating the constructor
    public Doctor(String name, String surname, LocalDate dateOfBirth, String contact, String licenseNumber, String dSpecialisation){
        super(name, surname, dateOfBirth, contact);
        this.licenseNumber = licenseNumber;
        this. dSpecialisation = dSpecialisation;
    }

    //creating getters and setters method for the attributes
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialisation() {
        return dSpecialisation;
    }

    public void setSpecialisation(String dSpecialisation) {
        this.dSpecialisation = dSpecialisation;
    }

}