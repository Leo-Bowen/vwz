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

    public SeeProductStock() {
        saveAndCloseProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SeeProductStock");
        frame.setContentPane(new SeeProductStock().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
