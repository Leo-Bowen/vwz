package com.company;

import com.models.EmployeeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class UpdateEmployee {
    private JPanel rootPanel;
    private JPanel secondPanel;
    private JButton returnButton;
    private JButton deleteButton;
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
    private static JFrame frame;

    public UpdateEmployee() {
        EmployeeController employeeController = new EmployeeController();

        tf_id.setEditable(false);
        tf_id.setText(String.valueOf(ListEmployee.selected_employee.getId()));
        tf_firstname.setText(ListEmployee.selected_employee.getFirstname());
        tf_lastname.setText(ListEmployee.selected_employee.getLastname());
        tf_birthdate.setText(String.valueOf(ListEmployee.selected_employee.getBirthdate()));
        tf_employmentdate.setText(String.valueOf(ListEmployee.selected_employee.getEntrydate()));
        tf_position.setText(ListEmployee.selected_employee.getPosition());
        tf_schedule.setText(ListEmployee.selected_employee.getSchedule());


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to save edit?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.dispose();
                if (opt == JOptionPane.YES_OPTION) {

                    try {
                        employeeController.updateEmployee(ListEmployee.selected_employee.getId(), tf_firstname.getText(), tf_lastname.getText(), Date.valueOf(tf_birthdate.getText()),Date.valueOf(tf_employmentdate.getText()),tf_position.getText(),tf_schedule.getText());
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (IllegalArgumentException err) {
                        JOptionPane.showMessageDialog(frame, "Please enter all required information correctly!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    ListEmployee.main(new String[0]);
                    frame.dispose();
                } else if (opt == JOptionPane.NO_OPTION) {
                    UpdateEmployee.main(new String[0]);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to remove this Employee?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.dispose();
                if (opt == JOptionPane.YES_OPTION) {

                    try {
                        employeeController.deleteEmployee(ListEmployee.selected_employee.getId());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(frame, "Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
                    ListEmployee.main(new String[0]);
                } else if (opt == JOptionPane.NO_OPTION) {
                    UpdateEmployee.main(new String[0]);
                }
            }
        });


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEmployee.main(new String[0]);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("UpdateEmployee");
        frame.setContentPane(new UpdateEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
