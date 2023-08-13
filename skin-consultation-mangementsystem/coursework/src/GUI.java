import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class GUI {

    public static void display() {

        JFrame frame = new JFrame();
        frame.setTitle("Westminster skin consultation");
        ImageIcon image = new ImageIcon("logo.jpeg");
        frame.setIconImage(image.getImage());

        JPanel nav_bar = new JPanel(new BorderLayout());
        JPanel container = new JPanel(new BorderLayout());

        //panel design
        nav_bar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nav_bar.setBackground(Color.white);
        nav_bar.setPreferredSize(new Dimension(0, 100));
        nav_bar.setBackground(Color.decode("#FFFFEF"));

        JPanel table = container(container);
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("img/5172658.jpg"));

        JLabel nav_label = (new JLabel("Welcome to Westminster Consultation", SwingConstants.CENTER));
        nav_label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        nav_bar.add(nav_label, BorderLayout.CENTER);
        frame.add(nav_bar, BorderLayout.NORTH);
        frame.add(table, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JPanel container(JPanel frame) {

        String[] col_identifier = { "Medical License Number", "Doctor full name", "Specialization", "Contact Number" };

        DefaultTableModel model = new DefaultTableModel();
        for (String column : col_identifier) {
            model.addColumn(column);
        }
        model.addRow(col_identifier);
        JPanel jtable = new JPanel();
        jtable.setLayout(new GridBagLayout());
        for (int i = 0; i < WestminsterConsultationManager.DocList.size(); i++) {
            model.addRow(new Object[] {
                    String.format("%04d", WestminsterConsultationManager.DocList.get(i).getLicenseNumber()),
                    WestminsterConsultationManager.DocList.get(i).getFirstName() + " "
                            + WestminsterConsultationManager.DocList.get(i).getLastname(),
                    WestminsterConsultationManager.DocList.get(i).getSpecialisation(),
                    WestminsterConsultationManager.DocList.get(i).getMobNo()
            });
        }
        JTable table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(0, 10));
        table.setRowHeight(20);
        for (int i = 0; i < 4; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(200);
        }
        table.setRowHeight(0, 30);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);

                return this;
            }
        });

        table.setVisible(true);
        table.setShowGrid(true);
        table.setRowSelectionAllowed(false);
        jtable.add(table);
        jtable.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        frame.add(jtable, BorderLayout.CENTER);

        JButton sortButton = new JButton("Sort Table");
        sortButton.setPreferredSize(new Dimension(100, 50));
        JPanel sortPanel = new JPanel();
        sortPanel.add(sortButton);
        jtable.add(sortPanel);

        // Create a row sorter for the table
        TableRowSorter<javax.swing.table.TableModel> sorter = new TableRowSorter<>(table.getModel());

        // Set the sorter for the table
        table.setRowSorter(sorter);

        // Add an action listener to the sort button
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Sort the table by the Doctor full name column (column 2) in ascending order (A-Z)
                sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
                sorter.sort();
            }
        });


        return frame;

    }

}
