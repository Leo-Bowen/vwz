package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel rootPanel;
    private JButton editOrderings;
    private JLabel helloLabel;
    private JButton orderProductsButton;
    private JButton editProductButton;
    private JButton addProductButton;
    private JButton editEmployeeButton;
    private JButton addEmployeeButton;

    public Dashboard() {
        orderProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editProductButton.addActionListener(new ActionListener() { //editProductButton
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addProductButton.addActionListener(new ActionListener() { //addProductButton
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dashboard");
        frame.setContentPane(new Dashboard().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
