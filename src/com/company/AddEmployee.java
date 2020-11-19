package com.company;

import javax.swing.*;

public class AddEmployee {
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enterCredentialsButton;
    private JTextField textField4;
    private JPanel secondPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddEmployee");
        frame.setContentPane(new AddEmployee().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
