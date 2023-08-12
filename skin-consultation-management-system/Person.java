//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1868307
//Date: 25/12/2022

package oopcw;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    LocalDate dateOfBirth;
    private String contact;

    public Person(String name, String surname, LocalDate dateOfBirth, String contact){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
    }

    //getters and setters of the attributes 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surnmae) {
        this.surname = surnmae;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}