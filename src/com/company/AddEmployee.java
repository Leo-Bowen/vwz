package com.company;

import javax.swing.*;

public class AddEmployee {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enterCredentialsButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddEmployee");
        frame.setContentPane(new AddEmployee().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
