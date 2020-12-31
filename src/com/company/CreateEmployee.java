package com.company;

import com.models.EmployeeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class CreateEmployee {
    private JPanel rootPanel;
    private JPanel secondPanel;
    private JButton saveButton;
    private JTextField tf_id;
    private JTextField tf_firstname;
    private JTextField tf_lastname;
    private JTextField tf_birthdate;
    private JTextField tf_employmentdate;
    private JTextField tf_position;
    private JTextField tf_schedule;
    private JLabel employeeIDLabel;
    private JLabel employeeFirstNameLabel;
    private JLabel employeeLastNameLabel;
    private JLabel employeeBirthdateLabel;
    private JLabel employeeDateOfEmploymentLabel;
    private JLabel employeePositionLabel;
    private JLabel employeeScheduleLabel;
    private JButton returnButton;
    private static JFrame frame;
    private EmployeeController employeeController;

    public CreateEmployee() {
        employeeController = new EmployeeController();

        tf_id.setEditable(false);
        tf_id.setText("ID will automatically be set by database");
        tf_employmentdate.setText(employeeController.getDate());

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    employeeController.addEmployee(tf_firstname.getText(), tf_lastname.getText(), Date.valueOf(tf_birthdate.getText()), Date.valueOf(tf_employmentdate.getText()), tf_position.getText(), tf_schedule.getText());
                } catch (ClassNotFoundException | SQLException err) {
                    err.printStackTrace();
                } catch (IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(frame, "Please enter all required information correctly!", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                Dashboard.main(new String[0]);
                frame.dispose();
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
        frame = new JFrame("AddEmployee");
        frame.setContentPane(new CreateEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
