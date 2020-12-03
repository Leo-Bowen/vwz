package com.company;

import javax.swing.*;

public class SeeEmployeeInfo {
    private JPanel rootPanel;
    private JButton saveAndCloseThisButton;
    private JTextArea leoWangTextArea;
    private JTextArea a111998TextArea;
    private JTextArea a10102020TextArea;
    private JTextArea a0001TextArea;
    private JPanel secondPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SeeEmployeeInfo");
        frame.setContentPane(new SeeEmployeeInfo().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
