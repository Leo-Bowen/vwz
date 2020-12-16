package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployee {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JTextField textField1;
    private JButton deleteEmployeeButton;
    private static JFrame frame;

    public DeleteEmployee() {
        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEmployeeInfo.main(new String[0]);
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "Employee successfully deleted!");
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("DeleteEmployee");
        frame.setContentPane(new DeleteEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

