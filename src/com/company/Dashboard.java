package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel rootPanel;
    private JButton editOrderButton;
    private JLabel helloLabel;
    private JPanel secondaryPanel;
    private JButton addOrderButton;
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
                ListEmployee.main(new String[0]);
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
                ListProduct.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateOrder.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOrder.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        logOutButton.addActionListener(new ActionListener() { //basic logout
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login.main(new String[0]);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                frame.setVisible(false);
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
