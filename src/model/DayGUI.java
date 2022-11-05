package model;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.JTableHeader;

public class DayGUI {
    private static JFrame dayFrame = new JFrame("DayGUI");
    private static JLabel dayInfo = new JLabel("22/2/2222");
    private static JButton addMealButton = new JButton("Add Meal");
    private static JButton removeMealButton = new JButton("Remove Meal");
    private static JTable dayTable;
    private static JTableHeader dayTableHeader;
    private static JScrollPane dayScrollPane;
    private static ListSelectionModel dayCellSelect;

    // This constructor will eventually take either a date or a file as an argument
    // in order to display the date and existing meals
    public DayGUI() {

        // Day label stored with dummy data for now
        dayInfo.setFont(new Font("Arial", Font.PLAIN, 36));
        dayInfo.setBounds(5, 30, 600, 40);

        // Creates addMealButton
        addMealButton.setBounds(520, 30, 120, 40);

        addMealButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addMealButton Pressed");

            }

        });

        // Creates removeMealButton
        removeMealButton.setBounds(650, 30, 120, 40);

        removeMealButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("removeMealButton Pressed");

            }

        });

        // Dummy data for table
        String data[][] = { { "Breakfast", "300", "12", "40", "18" },
                { "Lunch", "800", "30", "60", "13" },
                { "Snack", "120", "4", "5", "3" },
                { "Dinner", "1000", "27", "80", "20" },
        };

        String column[] = { "MEAL TYPE", "TOTAL CALORIES", "TOTAL FATS", "TOTAL CARBS", "TOTAL PROTEIN" };

        // Create Table
        dayTable = new JTable(data, column);

        // Create Header
        dayTableHeader = dayTable.getTableHeader();
        dayTableHeader.setBackground(Color.yellow);

        // Create Scroll Pane that Table goes in
        dayScrollPane = new JScrollPane(dayTable);
        dayScrollPane.setBounds(5, 100, 775, 300);

        // Enter mealGUI when attribute when cell is selected
        dayTable.setCellSelectionEnabled(true); // Allows cells in table to be selected
        dayCellSelect = dayTable.getSelectionModel();
        dayCellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // This function will later be used to open MealGUI for the meal that's selected
        dayCellSelect.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) { // This conditional prevents both mouth click press and release to
                                               // trigger listener, only press
                    String Data = null;
                    int[] row = dayTable.getSelectedRows();
                    int[] columns = dayTable.getSelectedColumns();
                    for (int i = 0; i < row.length; i++) {
                        for (int j = 0; j < columns.length; j++) {
                            Data = (String) dayTable.getValueAt(row[i], columns[j]);
                        }
                    }
                    System.out.println("Table element selected is: " + Data);
                }
            }

        });

        // Add components to frame
        dayFrame.add(dayInfo);
        dayFrame.add(addMealButton);
        dayFrame.add(removeMealButton);
        dayFrame.add(dayScrollPane);

        // Frame Details
        dayFrame.setSize(800, 450);
        dayFrame.setLayout(null);
        dayFrame.setLocationRelativeTo(null); // Window appears in center of screen
        dayFrame.setResizable(false); // Can't resize
        dayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If close window the compiler stops
        dayFrame.setVisible(true); // Window opens

    }

    public static void main(String[] args) {
        new DayGUI();
    }
}
