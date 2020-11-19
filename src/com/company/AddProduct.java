package com.company;

import javax.swing.*;

public class AddProduct {
    private JPanel rootPanel;
    private JButton saveProductInformationButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel secondPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddProduct");
        frame.setContentPane(new AddProduct().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
