package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListEmployeeInfo {
    private JPanel rootPanel;
    private JButton saveAndCloseThisButton;
    private JPanel secondPanel;
    private JButton updateEmployeeButton;
    private JList list1;
    private static JFrame frame;

    public ListEmployeeInfo() {
        saveAndCloseThisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.main(new String[0]);
                frame.setVisible(false);
            }
        });
        updateEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateEmployee.main(new String[0]);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("UpdateEmployeeInfo");
        frame.setContentPane(new ListEmployeeInfo().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
