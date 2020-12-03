package com.company;

import com.jdbc.Product;
import com.jdbc.VWZDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddEmployee {
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enterCredentialsButton;
    private JTextField textField4;
    private JPanel secondPanel;
    private static JFrame frame;

    public AddEmployee() {
        enterCredentialsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                  Dashboard.main(new String[0]);
                //frame.setVisible(false); //hides
                frame.dispose(); //deletes
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AddEmployee");
        frame.setContentPane(new AddEmployee().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
