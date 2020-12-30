package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this employee?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.setVisible(false);
                if (opt == JOptionPane.YES_OPTION) {
                    ListEmployee.main(new String[0]);
                } else if (opt == JOptionPane.NO_OPTION){
                    UpdateEmployee.main(new String[0]);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEmployee.main(new String[0]);
                frame.setVisible(false);
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
