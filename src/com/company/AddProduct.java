package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct {
    private JPanel rootPanel;
    private JButton saveProductInformationButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel secondPanel;
    private static JFrame frame;


    public AddProduct() {
        saveProductInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                Dashboard.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AddProduct");
        frame.setContentPane(new AddProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
