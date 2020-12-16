package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployee {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton saveAndCloseButton;
    private JButton deleteButton;
    private JTextArea textArea6;
    private static JFrame frame;

    public UpdateEmployee() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this employee?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.setVisible(false);
                if (opt == JOptionPane.YES_OPTION) {
                    ListEmployeeInfo.main(new String[0]);
                } else if (opt == JOptionPane.NO_OPTION){
                    UpdateEmployee.main(new String[0]);
                }
            }
        });
        saveAndCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEmployeeInfo.main(new String[0]);
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
