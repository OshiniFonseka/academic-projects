package oopcw;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements skinConsultationManager {

    // creating an array for doctors
    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);

    //creating array for the consultations
    public static ArrayList<String> consultations = new ArrayList<String>();

    // creating the constructor
    public WestminsterSkinConsultationManager(){
    }

    public static void main(String[] args) throws Exception {
        
        boolean menu = true;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        loadingDetails();  //loading previous information before starting the program
        
        while(menu){
            // the menu displayed in the console
            System.out.println("Select an option from the menu.");
            System.out.println("1. Add a new doctor to the system");
            System.out.println("2. Delete a doctor from the system");
            System.out.println("3. Print the list of doctors");
            System.out.println("4. Save the details");
            System.out.println("5. Interface");
            System.out.println("6. Quit");
            System.out.print("Enter the option number: ");

            //validation for selecting an option from the menu
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid input");
            }

            switch(choice){
                case 1:
                    WestminsterSkinConsultationManager.addingDoc();
                    break;
                case 2:
                    WestminsterSkinConsultationManager.removingDoc();
                    break;
                case 3:
                    WestminsterSkinConsultationManager.printingDoctors();
                    break;
                case 4:
                    WestminsterSkinConsultationManager.savingDetails();
                    break;
                case 5:
                    new gui();
                    break;
                case 6:

            }
        } 
    }

    //method for adding a new doctor
    public static void addingDoc() {
        Scanner input = new Scanner(System.in);

        if(doctors.size() >= 10){
            System.out.println("Doctor list has reached its limit. Delete one entry first.");
        }
        else{
            System.out.print("Enter doctor's name: ");
            String name = input.nextLine();
            System.out.print("Enter doctor's surname: ");
            String surname = input.nextLine();
            System.out.print("Enter date of birth(in the format yyyy-mm-dd): ");
            LocalDate dateOfBirth = LocalDate.parse(input.nextLine());
            System.out.print("Enter contact number: ");
            String contact = input.nextLine();
            System.out.print("Enter doctor's license number: ");
            String licenseNumber = input.nextLine();
            System.out.print("Enter doctor's specialisation: ");
            String dSpecialisation = input.nextLine();

            Doctor doctor1 = new Doctor(name, surname, dateOfBirth, contact, licenseNumber, dSpecialisation);
            doctors.add(doctor1);
            System.out.println("Doctor details have been successfully added");
        }   
    }

    // method for removing a doctor from the list
    public static void removingDoc() {
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the medical license number of the doctor you want to remove: ");
        String licenseNum = input.nextLine();

        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getLicenseNumber().equals(licenseNum)) {
            System.out.println("Doctor with the license number "+licenseNum+" has been deleted.");
            System.out.println("Information of the deleted doctor: "+doctors.get(i).getName());
            doctors.remove(i);
            count = doctors.size();
            System.out.println("Doctor has been deleted. Remaining doctors: " + count);
            }else{
                System.out.println("There are no doctors with that license number");
            }
        }
    
    }

    // method for printing the list of doctors
    public static void printingDoctors() {
        if(doctors.isEmpty()){
            System.out.println("No doctors to display at the moment");
        }else{
            //sorting the list in alphabetical order by surname
            Collections.sort(doctors, (d1, d2) -> d1.getSurname().compareTo(d2.getSurname()));
            for(Doctor doctor : doctors){
                System.out.println("Doctor list");
                System.out.println(doctor.getName()+ " " + doctor.getSurname());
            }
        }
    }

    //method for saving entered details
    public static void savingDetails() {

        try {
            //creating the text file to save details
            File fileObj = new File("savingDetails.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(fileObj);
            //converting data to readable data
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(doctors);

            objectOutputStream.flush();
            objectOutputStream.close();

            System.out.println("All details saved ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method for loading saved details
    public static void loadingDetails() {

        try {
            //getting the file data from the previously saved file
            FileInputStream fileInputStream = new FileInputStream("savingDetails.txt");
            //converting data to readable data
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Doctor> doctors1 = (ArrayList<Doctor>) objectInputStream.readObject();
            for (Doctor d : doctors1) {
                doctors.add(d);
            }

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Details loaded");
        } catch (IOException e) {
            System.out.println("Error Initializing Stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}