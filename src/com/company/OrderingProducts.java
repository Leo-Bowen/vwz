package com.company;

import javax.swing.*;

public class OrderingProducts {
    private JPanel panel1;
    private JButton saveAndSendOrderButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrderingProducts");
        frame.setContentPane(new OrderingProducts().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
