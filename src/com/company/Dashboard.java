package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel rootPanel;
    private JButton editOrderingsButton;
    private JLabel helloLabel;
    private JPanel secondaryPanel;
    private JButton orderProductsButton;
    private JButton editProductButton;
    private JButton addProductButton;
    private JButton editEmployeeButton;
    private JButton addEmployeeButton;
    private JButton logOutButton;
    private static JFrame frame;

    public Dashboard() {
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateEmployee.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateEmployeeInfo.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateProduct.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProduct.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        orderProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderingProducts.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editOrderingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FEHLT
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Dashboard");
        frame.setContentPane(new Dashboard().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
