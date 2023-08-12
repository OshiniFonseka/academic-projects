package oopcw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class tableForBookings {

    public tableForBookings(){
        WestminsterSkinConsultationManager docOb = new WestminsterSkinConsultationManager();

        //column names for the consultation viewing table
        String[] bookingCols = {"Doctor's name", "Patient's name", "Consultation no.", "Consultation Time", "Consultation Date"};

        //values displayed
        Object[][] addedVals = new Object[WestminsterSkinConsultationManager.consultations.size()][5];

        for (int i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {

            // addedVals[i][0]=WestminsterSkinConsultationManager.consultations.get(i).getDoc().getName();
            // addedVals[i][1]=WestminsterSkinConsultationManager.consultations.get(i).getPatient().getName();
            // addedVals[i][2]=WestminsterSkinConsultationManager.consultations.get(i).getConsulTime();
            // addedVals[i][3]=WestminsterSkinConsultationManager.consultations.get(i).getConsulDate();
        }


        JTable tableForBookings = new JTable(addedVals, bookingCols);
        tableForBookings.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Consultation cons = null;
                int conID = (Integer) tableForBookings.getValueAt(tableForBookings.getSelectedRow(),0);
                /* for (String c: WestminsterSkinConsultationManager.consultations) {
                    if (conID == c.getConId())
                    {
                        cons = c;
                    }
                }
                SaveConsultation saveConsultation = new SaveConsultation(cons); */
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        tableForBookings.setBackground(Color.WHITE);

        JFrame frame = new JFrame("Doctor details.");
        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableForBookings);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(0, 0, 800, 400);
        
        frame.setLayout(new FlowLayout());
        frame.add(panel);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tableForBookings.setAutoCreateRowSorter(true);
        
    }

}