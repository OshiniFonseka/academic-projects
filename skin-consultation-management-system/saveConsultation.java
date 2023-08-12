package oopcw;

import javax.swing.*;

public class saveConsultation {

    public saveConsultation(String consultations){

        JFrame frame = new JFrame("Viewing booked consultation");
    
        JLabel docName = new JLabel("Doctor's name: ");
        JTextField docNameField = new JTextField(Person.Doctor().getName());

        JLabel paName = new JLabel("Patient's name: ");
        JTextField paNameFeild = new JTextField(Person.getPatient().getName());

        JLabel dob = new JLabel("Date of birth: ");
        JTextField dobFeild = new JTextField(Patient.getDateOfBirth());
        
        JLabel conTime = new JLabel("Time: ");
        JTextField conTimeField = new JTextField(String.valueOf(Consultation.getConsultationTime()));

        JLabel conDate = new JLabel("Date: ");
        JTextField conDateFeild = new JTextField(String.valueOf(Consultation.getConsulDate()));

        JLabel cost = new JLabel("Cost: ");
        JTextField costFeild = new JTextField(String.valueOf(Consultation.getCost()));

        JLabel notes = new JLabel("Notes: ");
        JTextField notesField = new JTextField(Consultation.getNotes());

        frame.add(docName);
        frame.add(docNameField);
        frame.add(paName);
        frame.add(paNameFeild);
        frame.add(dob);
        frame.add(dobFeild);
        frame.add(conTime);
        frame.add(conTimeField);
        frame.add(conDate);
        frame.add(conDateFeild);
        frame.add(cost);
        frame.add(costFeild);
        frame.add(notes);
        frame.add(notesField);

        frame.setSize(500,500);
        frame.setVisible(true);
    }
}

