//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898888
//Date: 25/12/2022


import javax.crypto.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;


public class CW_GUI {



    //Creating a frame object
    static JFrame frame = new JFrame("Westminster Skin Consultation Centre");

    //creating a button to view doctor list
    static JButton DocButton = new JButton("View Doctors");

    // Create the consultation button
    static JButton consultationButton = new JButton("Book Consultations");

    // Create the View consultation button

    static JButton viewConsultButton = new JButton("View consultations");


    static JFrame formFrame = new JFrame("Book consultations");

    static JFrame tableFrame1;

    static JFrame tableFrame2;

    WestminsterConsultationManager manager;
    public void displayGui() {

        this.manager = manager;
        //designing the viewing doc button
        DocButton.setPreferredSize(new Dimension(250, 60));
        DocButton.setFocusable(false);
        DocButton.setBorder(BorderFactory.createEtchedBorder());

        //ACTION OF THE BUTTON
        DocButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // create a new frame and show the table in it
                JFrame tableFrame1 = new JFrame("Doctors");

                JPanel tablePanel1 = Container1(new JPanel(), tableFrame1);
                tableFrame1.add(tablePanel1);
                tableFrame1.setPreferredSize(new Dimension(800, 600));
                tableFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.dispose();
                tableFrame1.pack();
                tableFrame1.setVisible(true);
            }
        });


        //designing the Add Consultation button
        consultationButton.setPreferredSize(new Dimension(250, 60));
        consultationButton.setFocusable(false);
        consultationButton.setBorder(BorderFactory.createEtchedBorder());


        //ACTION OF THE BUTTON

        consultationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createConsultationForm();
            }
        });



        //designing the Viewing Consultation button
        viewConsultButton.setPreferredSize(new Dimension(250, 60));
        viewConsultButton.setFocusable(false);
        viewConsultButton.setBorder(BorderFactory.createEtchedBorder());


        //ACTION OF THE BUTTON
        viewConsultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // create a new frame and show the table in it
                JFrame tableFrame2 = new JFrame("View Consultations");

                JPanel tablePanel2 = Container2(new JPanel(), tableFrame2);
                tableFrame2.add(tablePanel2);
                tableFrame2.setPreferredSize(new Dimension(800, 600));
                tableFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.dispose();
                tableFrame2.pack();
                tableFrame2.setVisible(true);
            }
        });






        //Designing the four buttons
        Border comp = new CompoundBorder(new LineBorder(Color.lightGray, 6, true), new LineBorder(Color.black, 4));
        DocButton.setBorder(comp);
        consultationButton.setBorder(comp);
        viewConsultButton.setBorder(comp);




        JPanel buttonPanel = new JPanel(new BorderLayout()); // Create a panel with a BorderLayout
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));//Add some empty space above the button
        buttonPanel.add(DocButton, BorderLayout.NORTH); // Add the DocButton to the top of the panel
        buttonPanel.add(consultationButton, BorderLayout.WEST);
        buttonPanel.add(viewConsultButton, BorderLayout.SOUTH);
        frame.add(buttonPanel, BorderLayout.EAST); // Add the panel to the right side of the frame



        //creating panel objects
        JPanel headerPanel = new JPanel(new BorderLayout());
        JPanel Panel = new JPanel(new BorderLayout());



        //Designing dimension of the header panel
        headerPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setPreferredSize(new Dimension(0, 100));
        headerPanel.setBackground(Color.decode("#4b6678"));



        //Adding a heading text
        JLabel headerLabel = (new JLabel("Welcome to Skin Consultation Centre", SwingConstants.CENTER));
        headerLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        headerLabel.setForeground(Color.WHITE);



        //Adding a background image to the GUI
        ImageIcon bc_image = new ImageIcon("/Users/livw/IdeaProjects/coursework/src/SKIN CENTRE.jpeg");
        Image image = bc_image.getImage();
        Image temp_img = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        bc_image = new ImageIcon(temp_img);
        JLabel bg = new JLabel("", bc_image, JLabel.CENTER);

        bg.add(headerPanel);
        bg.setBounds(0, 0, 800, 500);


        //calling container1 method in display method
        JPanel table1 = Container1(Panel, tableFrame1);


        //calling container2 method in display method
        JPanel table2 = Container2(Panel, tableFrame2);


        //Adding the panels to the frame and setting frame dimensions
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(table1, BorderLayout.CENTER);
        frame.add(table2, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(900, 400));
        frame.add(bg, BorderLayout.CENTER);


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bg);
        frame.setVisible(true);

    }


    //Doc Table
    public JPanel Container1(JPanel frame, JFrame tableFrame1) {

        String[] col_identifier1 = {" MedicalLicense Number", "Doctor's Full Name", "Specialization field", "Mobile number"};

        DefaultTableModel modelTb1 = new DefaultTableModel();
        for (String column : col_identifier1) {
            modelTb1.addColumn(column);
        }
        modelTb1.addRow(col_identifier1);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        for (int i = 0; i < WestminsterConsultationManager.DocList.size(); i++) {
            modelTb1.addRow(new Object[]{
                     WestminsterConsultationManager.DocList.get(i).getLicenseNumber(),
                    WestminsterConsultationManager.DocList.get(i).getFirstName() + " "
                            + WestminsterConsultationManager.DocList.get(i).getLastname(),
                    WestminsterConsultationManager.DocList.get(i).getSpecialisation(),
                    WestminsterConsultationManager.DocList.get(i).getMobNo()
            });
        }


        JTable docTable = new JTable(modelTb1);

        docTable.setPreferredScrollableViewportSize(new Dimension(0, 40));
        docTable.setRowHeight(20);

        for (int i = 0; i < 4; i++) {
            docTable.getColumnModel().getColumn(i).setPreferredWidth(200);
        }
        docTable.setRowHeight(0, 40);

        docTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // Call the super method to set the text and alignment of the cell
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);

                // Customize the appearance of the cell based on the row and column
                if (row % 2 == 0) {
                    setBackground(Color.lightGray);
                } else {
                    setBackground(Color.white);
                }

                return this;
            }
        });


        docTable.setVisible(true);
        docTable.setShowGrid(true);
        docTable.setRowSelectionAllowed(true);
        panel1.add(docTable);
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        frame.add(panel1, BorderLayout.CENTER);


        //Creating the sort table button
        JButton buttonSort = new JButton("Sort Table");
        buttonSort.setPreferredSize(new Dimension(100, 50));

        //creating the sort panel
        JPanel sortPanel = new JPanel();
        sortPanel.add(buttonSort);
        panel1.add(sortPanel);


        //sorting the table using sort button
        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Sort the DocList by the doctor's name
                Collections.sort(WestminsterConsultationManager.DocList, new Comparator<>() {
                    @Override
                    public int compare(Doctor d1, Doctor d2) {
                        return d1.getFirstName().compareTo(d2.getFirstName());
                    }
                });


                // Update the table with the sorted list

                modelTb1.setRowCount(1); // Clear the existing rows
                for (int i = 0; i < WestminsterConsultationManager.DocList.size(); i++) {
                    modelTb1.addRow(new Object[]{
                            WestminsterConsultationManager.DocList.get(i).getLicenseNumber(),
                            WestminsterConsultationManager.DocList.get(i).getFirstName() + " "
                                    + WestminsterConsultationManager.DocList.get(i).getLastname(),
                            WestminsterConsultationManager.DocList.get(i).getSpecialisation(),
                            WestminsterConsultationManager.DocList.get(i).getMobNo()
                    });
                }
            }
        });


        //Creating the go back  button
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(100, 50));
        JPanel goBackPanel = new JPanel();
        goBackPanel.add(goBackButton);
        panel1.add(goBackPanel);


        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableFrame1.dispose(); // Closes the current frame
                displayGui();
            }
        });


        return frame;

    }


    //Consult Table
    public JPanel Container2(JPanel frame, JFrame tableFrame2) {
        String[] col_identifier2 = {"Patient ID", " First Name","Last Name", "Mobile number", "Date of birth", "Date", "Time", "Doctor's No", "Notes","Cost"};

        DefaultTableModel modelTb2 = new DefaultTableModel();

        for (String column : col_identifier2) {
            modelTb2.addColumn(column);
        }
        modelTb2.addRow(col_identifier2);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());

        // Add the patients to the table model
        for (consultation consultationx : WestminsterConsultationManager.consList) {
            modelTb2.addRow(new Object[]{
                    consultationx.getFirstName(),
                    consultationx.getLastname(),
                    consultationx.getMobNo(),
                    consultationx.getDateOfBirth(),
                    consultationx.getDate(),
                    consultationx.getTime(),
                    consultationx.getLicenseNumber(),
                    consultationx.getNotes(),
                    consultationx.getCost()

            });
        }

        JTable conTable = new JTable(modelTb2);

        conTable.setPreferredScrollableViewportSize(new Dimension(0, 40));
        conTable.setRowHeight(50);

        for (int i = 0; i < 4; i++) {
            conTable.getColumnModel().getColumn(i).setPreferredWidth(150);
        }
        conTable.setRowHeight(0, 30);

        conTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // Call the super method to set the text and alignment of the cell
                super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);

                // Customize the appearance of the cell based on the row and column
                if (row % 2 == 0) {
                    setBackground(Color.lightGray);
                } else {
                    setBackground(Color.white);
                }

                return this;
            }
        });

        conTable.setVisible(true);
        conTable.setShowGrid(true);
        conTable.setRowSelectionAllowed(true);
        panel2.add(conTable);
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        frame.add(panel2, BorderLayout.CENTER);


        //Creating the go back  button
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(100, 50));
        goBackButton.setBackground(Color.lightGray);
        JPanel goBackPanel = new JPanel();
        goBackPanel.add(goBackButton);
        goBackPanel.add(goBackButton, BorderLayout.WEST);
        panel2.add(goBackPanel);

        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableFrame2.dispose(); // Closes the current frame
                frame.setVisible(true);
            }
        });

        return frame;
    }


    private static void createConsultationForm() {
        // Create a panel to hold the form elements
        JPanel formPanel = new JPanel(new GridLayout(0, 2));

        // Create labels and text fields for the form
        JLabel IDLabel = new JLabel("Patient's ID:", SwingConstants.CENTER);
        JTextField IDField = new JTextField(10);
        JLabel firstNameLabel = new JLabel("First Name:", SwingConstants.CENTER);
        JTextField firstNameField = new JTextField(10);
        JLabel lastNameLabel = new JLabel("Last Name:", SwingConstants.CENTER);
        JTextField lastNameField = new JTextField(10);
        JLabel phoneNumberLabel = new JLabel("Phone Number:", SwingConstants.CENTER);
        JTextField phoneNumberField = new JTextField(10);
        JLabel dobLabel = new JLabel("Date of birth:", SwingConstants.CENTER);
        JTextField dobField = new JTextField(10);
        JLabel dateLabel = new JLabel("Date:", SwingConstants.CENTER);
        JTextField dateField = new JTextField(10);
        JLabel timeLabel = new JLabel("Time:", SwingConstants.CENTER);
        JTextField timeField = new JTextField(10);
        JLabel docNameLabel = new JLabel("Doctor's Name:", SwingConstants.CENTER);
        JTextField docNameField = new JTextField(10);
        JLabel docNoLabel = new JLabel("Doctor's License No:", SwingConstants.CENTER);
        JTextField docNoField = new JTextField(10);
        JLabel notesLabel = new JLabel("Notes:", SwingConstants.CENTER);
        JTextField notesField = new JTextField(10);




        // Add the labels and text fields to the form panel
        formPanel.add(IDLabel);
        formPanel.add(IDField);
        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(phoneNumberLabel);
        formPanel.add(phoneNumberField);
        formPanel.add(dobLabel);
        formPanel.add(dobField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(timeLabel);
        formPanel.add(timeField);
        formPanel.add(docNameLabel);
        formPanel.add(docNameField);
        formPanel.add(docNoLabel);
        formPanel.add(docNoField);
        formPanel.add(notesLabel);
        formPanel.add(notesField);


        // Create a button to submit the form
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.setBackground(Color.lightGray);
        formPanel.add(submitButton);

        // Create a button to cancel the form
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 50));
        cancelButton.setBackground(Color.lightGray);
        formPanel.add(cancelButton);

        // Add the form panel and submit button to the form frame
        formFrame.add(formPanel, BorderLayout.CENTER);




        //Creating the go back  button
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(100, 50));
        goBackButton.setBackground(Color.lightGray);
        formPanel.add(goBackButton);


        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formFrame.dispose(); // Closes the current frame
                frame.setVisible(true);
            }
        });


        // Set the size and layout of the form frame
        formFrame.setPreferredSize(new Dimension(500, 500));
        formFrame.pack();
        formFrame.setVisible(true);


        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the form fields
                String ID = IDField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String dob = dobField.getText();
                String date = dateField.getText();
                String time = timeField.getText();
                String doctorName = docNameField.getText();
                String doctorNo = docNoField.getText();
                String notes = notesField.getText();





                for (Doctor doctor : WestminsterConsultationManager.DocList) {
                    for (String lice : WestminsterConsultationManager.docLicenseNoList) {
                        if (doctor.getLicenseNumber().contains(lice) && lice.contains(doctorNo) && doctor.getAvailableDocDate().equals(LocalDate.parse(date)) && doctor.getAvailableDocTime().equals(LocalTime.parse(time))) {

                            WestminsterConsultationManager.docLicenseNoList.remove(lice);
                            // remove the doctor from the list for the consultation


                            boolean containsDef = false;
                            for (Patient patient : WestminsterConsultationManager.patients) {
                                if (patient.getPatientId().contains(ID)) {
                                    containsDef = true;
                                    break;
                                }
                                break;
                            }

                            if (containsDef) {
                                double cost1 = 25;

                                // New patient
                                Patient Patient = new Patient(firstName, lastName, LocalDate.parse(dob), phoneNumber, ID);
                                WestminsterConsultationManager.patients.add(Patient);

                                // New Consultation
                                consultation consultation = new consultation(firstName, lastName, LocalDate.parse(dob), phoneNumber, LocalDate.parse(date), LocalTime.parse(time), doctorNo, notes, cost1);
                                WestminsterConsultationManager.consList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                formFrame.dispose();
                                formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setVisible(true);


                                System.out.println(WestminsterConsultationManager.patients);
                                System.out.println(WestminsterConsultationManager.consList);

                            } else {
                                double cost2 = 15;
                                // New patient
                                Patient Patient = new Patient(firstName, lastName, LocalDate.parse(dob), phoneNumber, ID);
                                WestminsterConsultationManager.patients.add(Patient);

                                // New Consultation
                                consultation consultation = new consultation(firstName, lastName, LocalDate.parse(dob), phoneNumber, LocalDate.parse(date), LocalTime.parse(time), doctorNo, notes, cost2);
                                WestminsterConsultationManager.consList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                formFrame.dispose();
                                formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setVisible(true);


                            }

                            System.out.println(WestminsterConsultationManager.patients);
                            System.out.println(WestminsterConsultationManager.consList);

                        }// If LicenceCheckList not include the medical licence number patient allocated to  another doctor

                        else {
                            JOptionPane.showMessageDialog(null, "Your Doctor is already Booked & You are allocated to another doctor !");
                            String medLicence = "";
                            for (String nextlice : WestminsterConsultationManager.docLicenseNoList) {
                                if (!Objects.equals(nextlice, lice)) {
                                    medLicence = nextlice;
                                    break;
                                }
                                System.out.println("");
                            }
                            WestminsterConsultationManager.docLicenseNoList.remove(medLicence);


                            boolean containsDef = false;

                            for (Patient patient : WestminsterConsultationManager.patients) {
                                if (patient.getPatientId().contains(ID)) {
                                    containsDef = true;
                                    break;
                                }
                                break;
                            }


                            if (containsDef) {
                                double cost1 = 25;
                                // New patient
                                Patient Patient = new Patient(firstName, lastName, LocalDate.parse(dob), phoneNumber, ID);
                                WestminsterConsultationManager.patients.add(Patient);

                                // New Consultation
                                consultation consultation = new consultation(firstName, lastName, LocalDate.parse(dob), phoneNumber, LocalDate.parse(date), LocalTime.parse(time), doctorNo, notes, cost1);
                                WestminsterConsultationManager.consList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");

                                formFrame.dispose();
                                formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setVisible(true);


                                System.out.println(WestminsterConsultationManager.patients);
                                System.out.println(WestminsterConsultationManager.consList);
                            } else {
                                double cost2 = 15;

                                // New patient
                                Patient Patient = new Patient(firstName, lastName, LocalDate.parse(dob), phoneNumber, ID);
                                WestminsterConsultationManager.patients.add(Patient);

                                // New Consultation
                                consultation consultation = new consultation(firstName, lastName, LocalDate.parse(dob), phoneNumber, LocalDate.parse(date), LocalTime.parse(time), doctorNo, notes, cost2);
                                WestminsterConsultationManager.consList.add(consultation);
                                JOptionPane.showMessageDialog(null, "Consultation Added Successfully");


                                formFrame.dispose();
                                formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setVisible(true);


                            }

                        }
                        break;

                    }
                    break;

                }


                //Add an action listener to the clear button
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Clear all the form fields
                        IDField.setText("");
                        firstNameField.setText("");
                        lastNameField.setText("");
                        phoneNumberField.setText("");
                        dobField.setText("");
                        dateField.setText("");
                        timeField.setText("");
                        docNameField.setText("");
                        docNoField.setText("");
                        notesField.setText("");

                    }
                });
            }

        });


    }
}




