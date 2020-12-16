package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployeeInfo {
    private JPanel rootPanel;
    private JButton saveAndCloseThisButton;
    private JTextArea leoWangTextArea;
    private JTextArea a111998TextArea;
    private JTextArea a10102020TextArea;
    private JTextArea a0001TextArea;
    private JPanel secondPanel;
    private JButton deleteEmployeeButton;
    private static JFrame frame;

    public UpdateEmployeeInfo() {
        saveAndCloseThisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.main(new String[0]);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("UpdateEmployeeInfo");
        frame.setContentPane(new UpdateEmployeeInfo().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
