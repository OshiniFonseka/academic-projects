package oopcw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class gui {
    
    public gui() {

        //setting the frame for gui
        JFrame frame = new JFrame("Westminster Skin Consultation center");
        frame.setBounds(200, 20, 800, 100);
        frame.setFont(new Font("calibri", Font.BOLD, 45));
        frame.setSize(800, 800);

        //adding title on the home page of the gui
        JLabel title = new JLabel("WELCOME!", SwingConstants.CENTER);
        title.setBounds(100, 40, 500, 50);
        title.setFont(new Font(Font.SERIF, Font.BOLD,40));
        title.setForeground(Color.GRAY);  

        //creating button to view doctor list
        JButton viewDoctors = new JButton("VIEW DOCTORS");
        viewDoctors.setBounds(220,200 , 300 , 50);
        viewDoctors.setFont(new Font(Font.SERIF, Font.PLAIN,15));
        viewDoctors.setForeground(Color.WHITE);
        viewDoctors.setBackground(Color.GRAY);
        viewDoctors.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    new docTable();
            }
        });
    
        //creating the button to add consultations
        JButton addConsultation = new JButton("BOOK A CONSULTATION");
        addConsultation.setBounds(220,300, 300, 50);
        addConsultation.setFont(new Font(Font.SERIF, Font.PLAIN,15));
        addConsultation.setForeground(Color.WHITE);
        addConsultation.setBackground(Color.GRAY);
        addConsultation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new addConsultation(WestminsterSkinConsultationManager.doctors);   
            }
        });

        // creating button to view booking details
        JButton bookingDetails = new JButton("VIEW BOOKINGS");
        bookingDetails.setBounds(220,400, 300, 50);
        bookingDetails.setFont(new Font(Font.SERIF, Font.PLAIN,15));
        bookingDetails.setForeground(Color.WHITE);
        bookingDetails.setBackground(Color.GRAY);
        bookingDetails.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    new tableForBookings();
            }
        });

        frame.add(title);
        frame.add(viewDoctors);
        frame.add(bookingDetails);
        frame.add(addConsultation);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}