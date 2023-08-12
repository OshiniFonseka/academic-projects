package oopcw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

public class docTable extends JTable {

    public docTable(){
        WestminsterSkinConsultationManager docOb = new WestminsterSkinConsultationManager();

        //column names
        String[] docColumns = {"First name", "Last name", "Contact", "DOB", "Licence number","Speciality"};

        // data displayed in the table
        Object[][] addedVals = new Object[docOb.doctors.size()][10];

        for(int i = 0; i < addedVals.length; i++){
            addedVals[i][0] = docOb.doctors.get(i).getName();
            addedVals[i][1] = docOb.doctors.get(i).getSurname();
            addedVals[i][2] = docOb.doctors.get(i).getContact();
            addedVals[i][3] = docOb.doctors.get(i).getDateOfBirth();
            addedVals[i][4] = docOb.doctors.get(i).getLicenseNumber();
            addedVals[i][5] = docOb.doctors.get(i).getSpecialisation();
        }

        //creating doctor table
        JTable docTable =new JTable(addedVals, docColumns);
        docTable.setBounds(30, 40, 200, 300);

        JFrame frame = new JFrame("Details of the doctors in the center");
        frame.setBackground(Color.GRAY);
        JPanel container = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(docTable);
        container.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(800,400));
        scrollPane.setBounds(0, 0, 800, 400);
        frame.add(scrollPane);

        //sort button to sort the list alphabetically
        JButton sorting = new JButton("sort");
        sorting.setSize(25, 20);
        sorting.setBackground(Color.GRAY);
        container.add(sorting, BorderLayout.SOUTH);

        sorting.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                //gets the surnames in alphabetical order
                Comparator<Doctor> comp = Comparator.comparing(Doctor::getSurname);
                Collections.sort(WestminsterSkinConsultationManager.doctors, comp);
                Object[][] addedVals = new Object[docOb.doctors.size()][9];

                for(int j = 0; j < addedVals.length; j++){
                    addedVals[j][0] = docOb.doctors.get(j).getName();
                    addedVals[j][1] = docOb.doctors.get(j).getSurname();
                    addedVals[j][2] = docOb.doctors.get(j).getContact();
                    addedVals[j][3] = docOb.doctors.get(j).getDateOfBirth();
                    addedVals[j][4] = docOb.doctors.get(j).getLicenseNumber();
                    addedVals[j][5] = docOb.doctors.get(j).getSpecialisation();

                }

                JTable newTable = new JTable(addedVals, docColumns);
                scrollPane.getViewport().remove(docTable);
                scrollPane.getViewport().add(newTable);
                scrollPane.revalidate();
                frame.repaint();

            }
        });

        frame.add(container);
        frame.add(sorting);
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        docTable.setAutoCreateRowSorter(true);
    }   
} 