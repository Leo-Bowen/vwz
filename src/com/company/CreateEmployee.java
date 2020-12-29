package com.company;

import com.models.EmployeeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class CreateEmployee {
    private JPanel rootPanel;
    private JButton saveEmployeeButton;
    private JTextField tf_firstname;
    private JTextField tf_lastname;
    private JTextField tf_birthdate;
    private JTextField tf_employmentdate;
    private JTextField tf_position;
    private JTextField tf_schedule;
    private JPanel secondPanel;
    private JLabel employeeFirstNameLabel;
    private JLabel employeeLastNameLabel;
    private JLabel employeeBirthdateLabel;
    private JLabel employeeDateOfEmploymentLabel;
    private JLabel employeePositionLabel;
    private JLabel employeeScheduleLabel;
    private static JFrame frame;
    private EmployeeController employeeController;

    public CreateEmployee() {
        saveEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                try {
                    employeeController = new EmployeeController();
                    employeeController.addEmployee(tf_firstname.getText(), tf_lastname.getText(), Date.valueOf(tf_birthdate.getText()), Date.valueOf(tf_employmentdate.getText()), tf_position.getText(), tf_schedule.getText());
                } catch (ClassNotFoundException | SQLException err) {
                    err.printStackTrace();
                }
                Dashboard.main(new String[0]);
                //frame.setVisible(false); //hides
                frame.dispose(); //deletes
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AddEmployee");
        frame.setContentPane(new CreateEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
