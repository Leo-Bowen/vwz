package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderingProducts {
    private JPanel rootPanel;
    private JButton saveAndSendOrderButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel secondPanel;
    private static JFrame frame;

    public OrderingProducts() {
        saveAndSendOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                Dashboard.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("OrderingProducts");
        frame.setContentPane(new OrderingProducts().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
