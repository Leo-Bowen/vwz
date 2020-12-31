package com.company;

import com.models.Employee;
import com.models.EmployeeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class ListEmployee {
    private JPanel rootPanel;
    private JButton returnButton;
    private JPanel secondPanel;
    private JButton updateButton;
    private JTable employeeTable;
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
                    frame.dispose();
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
        frame = new JFrame("UpdateEmployeeInfo");
        frame.setContentPane(new ListEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
