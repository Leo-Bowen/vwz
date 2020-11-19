package com.company;

import javax.swing.*;

public class AddProduct {
    private JPanel panel1;
    private JButton saveProductInformationButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddProduct");
        frame.setContentPane(new AddProduct().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
