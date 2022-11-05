package model;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.JTableHeader;

public class MealGUI {
    private static JFrame mealFrame = new JFrame("MealGUI");
    private static JLabel mealInfo = new JLabel("Breakfast at 22/2/2222 2:22AM");
    private static JButton addFoodButton = new JButton("Add Food");
    private static JButton removeFoodButton = new JButton("Remove Food");
    private static JTable mealTable;
    private static JTableHeader mealTableHeader;
    private static JScrollPane mealScrollPane;
    private static ListSelectionModel mealCellSelect;

    // This constructor will eventually take a meal as an argument
    // in order to display mealType, date, and foodList
    public MealGUI() {

        // Meal label stored with dummy data for now
        mealInfo.setFont(new Font("Arial", Font.PLAIN, 36));
        mealInfo.setBounds(5, 30, 600, 40);

        // Creates addFoodButton
        addFoodButton.setBounds(520, 30, 120, 40);

        addFoodButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addFoodButton Pressed");

            }

        });

        // Creates removeFoodButton
        removeFoodButton.setBounds(650, 30, 120, 40);

        removeFoodButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("removeFoodButton Pressed");

            }

        });

        // Dummy data for table
        String data[][] = { { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" },
                { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" },
                { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" },
                { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" },
                { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" },
                { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" },
                { "Egg", "10", "2", "1", "6" },
                { "Toast", "120", "9", "3", "1" },
                { "Yogurt", "80", "4", "5", "3" }, };

        String column[] = { "FOOD", "CALORIES", "CARBS", "FATS", "PROTEIN" };

        // Create Table
        mealTable = new JTable(data, column);

        // Create Header
        mealTableHeader = mealTable.getTableHeader();
        mealTableHeader.setBackground(Color.yellow);

        // Create Scroll Pane that Table goes in
        mealScrollPane = new JScrollPane(mealTable);
        mealScrollPane.setBounds(5, 100, 775, 300);

        // Edit food attribute when cell is selected
        mealTable.setCellSelectionEnabled(true); // Allows cells in table to be selected
        mealCellSelect = mealTable.getSelectionModel();
        mealCellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // This function will later be used to edit food items
        mealCellSelect.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) { // This conditional prevents both mouth click press and release to
                                               // trigger listener, only press
                    String Data = null;
                    int[] row = mealTable.getSelectedRows();
                    int[] columns = mealTable.getSelectedColumns();
                    for (int i = 0; i < row.length; i++) {
                        for (int j = 0; j < columns.length; j++) {
                            Data = (String) mealTable.getValueAt(row[i], columns[j]);
                        }
                    }
                    System.out.println("Table element selected is: " + Data);
                }
            }

        });

        // Add components to frame
        mealFrame.add(mealInfo);
        mealFrame.add(addFoodButton);
        mealFrame.add(removeFoodButton);
        mealFrame.add(mealScrollPane);

        // Frame Details
        mealFrame.setSize(800, 450);
        mealFrame.setLayout(null);
        mealFrame.setLocationRelativeTo(null); // Window appears in center of screen
        mealFrame.setResizable(false); // Can't resize
        mealFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If close window the compiler stops
        mealFrame.setVisible(true); // Window opens

    }

    public static void main(String[] args) {
        new MealGUI();
    }
}
