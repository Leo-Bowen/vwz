package com.company;

import com.models.Employee;
import com.models.EmployeeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

public class ListEmployee {
    private JPanel rootPanel;
    private JButton returnButton;
    private JButton updateButton;
    private JTable employeeTable;
    private JTextField tf_search;
    private static JFrame frame;

    public static Employee selected_employee;

    public ListEmployee() {
        EmployeeController employeeController = new EmployeeController();

        try {
            employeeController.loadEmployee(employeeTable);
            employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        employeeController.searchEmployee(employeeTable, tf_search.getText());
                    } catch (ClassNotFoundException | SQLException Exception) {
                        Exception.printStackTrace();
                    } catch (PatternSyntaxException patternSyntaxException){
                        JOptionPane.showMessageDialog(frame, "Please enter valid Syntax!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = employeeTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Select an Employee first!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    selected_employee = new Employee(
                            Integer.parseInt(employeeTable.getModel().getValueAt(row, 0).toString()),
                            employeeTable.getModel().getValueAt(row, 1).toString(),
                            employeeTable.getModel().getValueAt(row, 2).toString(),
                            Date.valueOf(employeeTable.getModel().getValueAt(row, 3).toString()),
                            Date.valueOf(employeeTable.getModel().getValueAt(row, 4).toString()),
                            employeeTable.getModel().getValueAt(row, 5).toString(),
                            employeeTable.getModel().getValueAt(row, 6).toString());
                    UpdateEmployee.main(new String[0]);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.main(new String[0]);
                frame.dispose();
            }
        });

    }

    public static void main(String[] args) {
        frame = new JFrame("Employee List");
        frame.setContentPane(new ListEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ImageIcon img = new ImageIcon("VWZ_icon.png");
        frame.setIconImage(img.getImage());
    }
}
