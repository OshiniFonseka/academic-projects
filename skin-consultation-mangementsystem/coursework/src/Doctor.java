//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898888
//Date: 25/12/2022

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

public class Doctor extends Person implements Comparable <Doctor> {

    //Declaring the attributes
    private String licenseNumber;
    public String specialisation;

    private LocalDate AvailableDocDate;

    private LocalTime AvailableDocTime;



    //Creating the doctor constructor

    public Doctor(String firstName, String lastName, LocalDate dateOfBirth,LocalDate AvailableDocDate,LocalTime AvailableDocTime,String mobNo, String licenseNumber, String specialisation) {
        super(firstName, lastName, dateOfBirth, mobNo);

        this.AvailableDocTime = AvailableDocTime;
        this.AvailableDocDate = AvailableDocDate;
        this.licenseNumber = licenseNumber;
        this.specialisation = specialisation;
    }


    public LocalDate getAvailableDocDate() {
        return AvailableDocDate;
    }

    public void setAvailableDocDate(LocalDate availableDocDate) {
        AvailableDocDate = availableDocDate;
    }

    public LocalTime getAvailableDocTime() {
        return AvailableDocTime;
    }

    public void setAvailableDocTime(LocalTime availableDocTime) {
        AvailableDocTime = availableDocTime;
    }

    public String getLicenseNumber() {

        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public String getSpecialisation() {

        return specialisation;
    }

    public void setSpecialisation(String specialisation) {

        this.specialisation = specialisation;
    }


    @Override
    public int compareTo(Doctor o) {
        return 0;
    }


}




