//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898888
//Date: 25/12/2022


import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.Comparator;


public class WestminsterConsultationManager implements SkinConsultationManager {

    public static LocalDate dateAvailableValidate(String AvailableDocDate){
        LocalDate AvailableDate = LocalDate.parse(AvailableDocDate, DateTimeFormatter.ISO_DATE);
        return AvailableDate;
    }


    public static LocalTime timeAvailableValidate(String AvailableDocTime){
        LocalTime AvailableTime = LocalTime.parse(AvailableDocTime,DateTimeFormatter.ISO_TIME);
        return AvailableTime;
    }

    public static Scanner sc = new Scanner(System.in);                             //getting inputs using Scanner class

    public static ArrayList<Doctor> DocList = new ArrayList<>(10);    //Creating the doctor array list
    public static ArrayList<Patient> patients = new ArrayList<>();                 //Creating the patient array list

    public static ArrayList<String> docLicenseNoList = new ArrayList<>();          //Creating the doctors license no array list

    public static ArrayList<consultation> consList = new ArrayList<>();            //Creating the consultation array list


    public void run (){
        readSavedInformation();
        CW_GUI gui = new CW_GUI();
        while (true) {
            //Displaying all the menu options
            System.out.println();
            System.out.println(">>>>>>>>>>>>>>>>>> WELCOME TO THE SKIN CONSULTATION CENTRE. <<<<<<<<<<<<<<<");
            System.out.println();
            System.out.println("<<<<<<<<<<<<<<<<  Menu options  >>>>>>>>>>>>>>>");
            System.out.println();
            System.out.println("1 or AD  : <----Add a new doctor------------------>");
            System.out.println("2 or RD  : <----Remove a doctor from the list----->");
            System.out.println("3 or PD  : <----Print the list of doctors--------->");
            System.out.println("4 or SV  : <----Saving a in a file.--------------->");
            System.out.println("5 or GUI : <----Open the GUI.--------------------->");
            System.out.println("6 or EXT : <----Exit the program.----------------->");
            System.out.println();
            System.out.println("Enter the option no you want to perform from the above menu option list: ");
            String action = sc.next().toUpperCase();


            switch (action) {
                case "1":
                case "AD":
                    addingDoctor();
                    break;
                case "2":
                case "RD":
                    removingDoctor();
                    break;
                case "3":
                case "PD":
                    printListOfDoctors();
                    break;
                case "4":
                case "SV":
                    saveFile();
                    break;
                case "5":
                case "GUI":
                    gui.displayGui();
                    break;
                case "6":
                case "EXT":
                    exitProgram();
                    break;
                default:
                    System.err.println("Invalid action.Please enter a valid input");
                    break;
            }

        }

    }



    @Override
    public void addingDoctor() {                                        // Method to add a new doctor to the list.

        System.out.println("Enter doctor's first name: ");              //Getting doctors information as inputs
        String firstName = sc.next();

        System.out.println("Enter doctor's last name: ");
        String lastName = sc.next();

        System.out.println("Enter doctor's date of birth: ");
        LocalDate DateOfBirth = null;

        try {
            DateOfBirth = LocalDate.parse(sc.next());
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date!!!. Please enter a valid date in the format yyyy-mm-dd: ");


        }
        while (DateOfBirth == null) {
            try {
                DateOfBirth = LocalDate.parse(sc.next());
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date !!!. Please enter a valid date in the format yyyy-mm-dd: ");

            }
        }


        System.out.print("Enter your Available Date : ");
        String AvailableDocDate = sc.next();
        LocalDate AvailableDate = dateAvailableValidate(AvailableDocDate);


        System.out.print("Enter Your Available Time: ");
        String AvailableDocTime = sc.next();
        LocalTime AvailableTime = timeAvailableValidate(AvailableDocTime);


        System.out.println("Enter doctor's mobile number: ");
        String mobNo = sc.next();

        System.out.println("Enter doctor's license Number: ");
        String licenseNumber = sc.next();



        System.out.println("Enter doctor's specialisation (Ex:cosmetic dermatology, medical dermatology, paediatric dermatology..");
        String specialisation = sc.next();

        Doctor doctor1 = new Doctor(firstName, lastName, DateOfBirth,AvailableDate,AvailableTime, mobNo, licenseNumber, specialisation);                     //Creating the doctor object

        this.DocList.add(doctor1);
        System.out.println("A doctor has been added successfully");



        docLicenseNoList.add(doctor1.getLicenseNumber());

    }


    @Override
    public void removingDoctor() {                        //Method to delete a doctor from the list.

        int count = 0;
        System.out.println("Enter doctor's license Number: ");
        String licenseNumber = sc.next();


        for (int i = 0; i < this.DocList.size(); i++) {
            if (this.DocList.get(i).getLicenseNumber().equals(licenseNumber)) {
                System.out.println("The information of the deleted doctor: " + this.DocList.get(i).getFirstName());     //Printing the deleted doctor's info
                this.DocList.remove(i);
                count = this.DocList.size();
                System.out.println("The doctor has been successfully deleted.Remaining doctors: " + count);   //Printing available slots after a doctor has  been deleted

                return;
            }

        }
        System.err.println("Invalid license number!.Please check and try again.");


        for (String doctor: docLicenseNoList ){
            if(doctor == licenseNumber){
                docLicenseNoList.remove(licenseNumber);
                break;
            }
        }

    }

    @Override
    public void printListOfDoctors() {                                           //Method to print the list of doctors.

        Collections.sort(DocList, new Comparator<Doctor>() {                     //Sorting the doctors using the surname in alphabetical order.

            @Override
            public int compare(Doctor doctor1, Doctor doctor2) {                 //Comparing doctors surnames using CompareTo
                return doctor1.getLastname().compareTo(doctor2.getLastname());
            }

        });


        int i = 1;
        for (Doctor doctor1: DocList) {                                            //Printing the information of doctors after sorting has been done
            System.out.println("---Doctor " + i + "---");
            System.out.println("First Name:" + doctor1.getFirstName() );
            System.out.println("Last Name: " + doctor1.getLastname());
            System.out.println("Date of Birth: " + doctor1.getDateOfBirth());
            System.out.println("Mobile Number: " + doctor1.getMobNo());
            System.out.println("Available Date: " + doctor1.getAvailableDocDate());
            System.out.println("Available Time: " + doctor1.getAvailableDocTime());
            System.out.println("License number: " + doctor1.getLicenseNumber());
            System.out.println("Specialisation: " + doctor1.getSpecialisation());

        }
    }



    @Override
    public void saveFile() {
        //Method to save the information in a file.
        int docCount = DocList.size();

        try {
            FileWriter saveDoc = new FileWriter("saveDoc.txt");
            System.out.println(docCount);
            saveDoc.write(String.valueOf(docCount));
            saveDoc.write("\n");
            for (int i = 0; i < DocList.size(); i++) {
                saveDoc.write(DocList.get(i).getFirstName());
                saveDoc.write("\n");

                saveDoc.write(DocList.get(i).getLastname());
                saveDoc.write("\n");

                saveDoc.write(String.valueOf(DocList.get(i).getDateOfBirth()));
                saveDoc.write("\n");

                saveDoc.write(String.valueOf(DocList.get(i).getAvailableDocDate()));
                saveDoc.write("\n");

                saveDoc.write(String.valueOf(DocList.get(i).getAvailableDocTime()));
                saveDoc.write("\n");

                saveDoc.write(DocList.get(i).getMobNo());
                saveDoc.write("\n");

                saveDoc.write(DocList.get(i).getLicenseNumber());
                saveDoc.write("\n");

                saveDoc.write(DocList.get(i).getSpecialisation());
                saveDoc.write("\n");
            }
            saveDoc.close();
            System.out.println();
            System.out.println("Saved successfully");
            System.out.println();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readSavedInformation() {
        // File reading information
        File file = new File("saveDoc.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int docCount = Integer.parseInt(reader.readLine());

            for (int i=0; docCount>i; i++){
                String firstName = (reader.readLine());
                String lastName = (reader.readLine());
                LocalDate DateOfBirth = LocalDate.parse(reader.readLine());

                LocalDate AvailableDate = LocalDate.parse((reader.readLine()));
                LocalTime AvailableTime = LocalTime.parse((reader.readLine()));
                String mobNo =(reader.readLine());
                String licenseNumber =(reader.readLine());
                String specialisation =(reader.readLine());

                Doctor doctor1 = new Doctor(firstName, lastName, DateOfBirth,AvailableDate,AvailableTime, mobNo, licenseNumber, specialisation);
                DocList.add(doctor1);
            }

        }
        catch (IOException e) {
            System.out.println("Error while reading information to file: " + e.getMessage());
        }
    }

    @Override
    public void exitProgram() {     //Method to Exist the program.

        System.out.println("You have successfully existed the program.Have a nice day!.");
        System.exit(0);

    }

}





