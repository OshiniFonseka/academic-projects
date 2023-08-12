package oopcw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class addConsultation implements ActionListener {

    public addConsultation(ArrayList<Doctor> doctors){

        //creating add consultation frame
        JFrame frame = new JFrame("Book consultation");
        frame.setBounds(500, 100, 600, 100);
        frame.setFont(new Font(Font.SERIF, Font.PLAIN,30));

        //naming columns of the form
        JLabel columnPatient = new JLabel("Patient's details");
        columnPatient.setBounds(30, 30, 200, 30);
        columnPatient.setFont(new Font(Font.SERIF, Font.BOLD,20));

        JLabel columnBooking = new JLabel("Booking details");
        columnBooking.setBounds(30, 280, 200, 30);
        columnBooking.setFont(new Font(Font.SERIF, Font.BOLD,20));

        //collecting patient's details
        JLabel fname = new JLabel("First name :");
        fname.setBounds(30, 60, 200, 30);
        JTextField fnameField = new JTextField();
        fnameField.setBounds(250, 60, 300, 30);

        JLabel lname = new JLabel("Last name :");
        lname.setBounds(30, 100, 200, 30);
        JTextField lnameField = new JTextField();
        lnameField.setBounds(250, 100, 300, 30);

        JLabel id = new JLabel("Id :");
        id.setBounds(30, 140, 200, 30);
        JTextField idField = new JTextField();
        idField.setBounds(250, 140, 300, 30);

        JLabel dob = new JLabel("Date of birth (yyyy-mm-dd) :");
        dob.setBounds(30, 180, 200, 30);
        JTextField dobField = new JTextField();
        dobField.setBounds(250, 180, 300, 30);

        JLabel contact = new JLabel("Contact :");
        contact.setBounds(30, 220, 200, 30);
        JTextField contactField = new JTextField();
        contactField.setBounds(250, 220, 300, 30);

        //collecting booking details
        JLabel selectDoctor = new JLabel("Select a doctor :");
        selectDoctor.setBounds(30, 320, 200, 30);
        ArrayList<Doctor> newList;
        newList = doctors;
        String[] names = new String[newList.size()];

      /*    for (int i = 0; i < newList.size(); i++) {
            Doctor d = newList.get(i);
            String name = "Dr. " + d.getName() + " " + d.getSurName();
            names[i] = name + " " + d.getLicencenumber();
        } */

        //creating drop down menu to check the list of doctors
        JComboBox availableDoctors = new JComboBox(names);
        availableDoctors.setBounds(250, 320, 300, 30);
        availableDoctors.setBackground(Color.WHITE);

        for (Doctor doc : WestminsterSkinConsultationManager.doctors){
            String data = (String) availableDoctors.getSelectedItem().toString().split(" ")[3];
            System.out.println(data);
            if(data.equalsIgnoreCase(doc.getLicenseNumber())){
                System.out.println("yes");
                Doctor d = doc;
            }
        }

        JLabel date = new JLabel("Date (in the format yyyy-mm-dd): ");
        date.setBounds(30, 360, 200, 30);
        JTextField dateFeild = new JTextField();
        dateFeild.setBounds(250, 360, 300, 30);

        JLabel time = new JLabel("Starting time :");
        time.setBounds(30, 400, 200, 30);
        JTextField timeFeild = new JTextField();
        timeFeild.setBounds(250, 400, 300, 30);

        JLabel duration = new JLabel("Consultation duration: ");
        duration.setBounds(30, 440, 200, 30);
        JTextField durationFeild = new JTextField();
        durationFeild.setBounds(250, 440, 300, 30);
        JLabel descriptionText = new JLabel("- in hours");
        descriptionText.setBounds(250, 440, 300, 30);

        JButton availability = new JButton("Check if available");
        availability.setBounds(580, 440, 150, 30);
        availability.setForeground(Color.WHITE);
        availability.setBackground(Color.GRAY);

        /* availability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object d;
                if (!LocalDate.parse(dateFeild.getText()).isEqual(d.getAvailableDate())) {
                    JOptionPane.showMessageDialog(null, "Date not available");
                }
                if (!LocalTime.parse(timeFeild.getText()).equals(d.getStartTime()) || LocalTime.parse(timeFeild.getText()).isAfter(d.getStartTime())) {
                    JOptionPane.showMessageDialog(null, "Time Not Available");
                }
            }
        }); */

        JLabel notes = new JLabel("Notes :");
        notes.setBounds(30, 480, 200, 30);
        JTextArea noteArea = new JTextArea();
        noteArea.setBounds(250, 480, 200, 100);

        JButton clear = new JButton("Clear");
        clear.setBounds(580, 550, 150, 30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.GRAY);
        clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fnameField.setText(null);
                lnameField.setText(null);
                idField.setText(null);
                dobField.setText(null);
                contactField.setText(null);

                dateFeild.setText(null);
                timeFeild.setText(null);
                durationFeild.setText(null);
                noteArea.setText(null);
            }
        });

        //book button to make the booking
        JButton booking = new JButton("BOOK");
        booking.setBounds(360, 620, 100, 40);
        booking.setForeground(Color.WHITE);
        booking.setBackground(Color.GRAY);
        /* booking.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
 */
        //adding all components to the frame
        frame.add(columnPatient);
        frame.add(columnBooking);
        frame.add(fname);
        frame.add(fnameField);
        frame.add(lname);
        frame.add(lnameField);
        frame.add(id);
        frame.add(idField);
        frame.add(dob);
        frame.add(dobField);
        frame.add(contact);
        frame.add(contactField);
        frame.add(selectDoctor);
        frame.add(availableDoctors);
        frame.add(date);
        frame.add(dateFeild);
        frame.add(time);
        frame.add(timeFeild);
        frame.add(duration);
        frame.add(descriptionText);
        frame.add(durationFeild);
        frame.add(clear);
        frame.add(availability);
        frame.add(noteArea);
        frame.add(notes);

        frame.add(booking, BorderLayout.SOUTH);
        frame.setSize(800, 800);
        frame.setLayout(null);  //setlayout determines the size and position of the components
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
}