package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeProductStock {
    private JPanel rootPanel;
    private JButton saveAndCloseProductButton;
    private JTextArea maxiGlanzGeschirrspülmittelTextArea;
    private JTextArea a00001TextArea;
    private JTextArea a250TextArea;
    private JTextArea a332010TextArea;
    private JPanel secondPanel;
    private static JFrame frame;

    public SeeProductStock() {
        saveAndCloseProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                Dashboard.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("SeeProductStock");
        frame.setContentPane(new SeeProductStock().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
