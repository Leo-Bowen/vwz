package com.company;

import javax.swing.*;

public class DeleteProduct {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JButton deleteProductButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DeleteProduct");
        frame.setContentPane(new DeleteProduct().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
