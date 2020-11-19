package com.company;

import javax.swing.*;

public class SeeProductStock {
    private JPanel panel1;
    private JButton saveAndCloseProductButton;
    private JTextArea maxiGlanzGeschirrspülmittelTextArea;
    private JTextArea a000001TextArea;
    private JTextArea maxiGlanzGmbHTextArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SeeProductStock");
        frame.setContentPane(new SeeProductStock().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
