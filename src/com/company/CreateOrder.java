package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOrder {
    private JPanel rootPanel;
    private JPanel secondPanel;
    private JButton returnButton;
    private JButton saveButton;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_quantity;
    private JTextField tf_orderdate;
    private JTextField tf_url;
    private JCheckBox status_checkbox;
    private static JFrame frame;

    public CreateOrder() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                Dashboard.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Create Orders");
        frame.setContentPane(new CreateOrder().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
