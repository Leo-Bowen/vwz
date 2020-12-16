package com.company;

import javax.swing.*;

public class DeleteEmployee {
    private JPanel rootPanel;
    private JTextArea leoWangTextArea;
    private JTextArea a0001TextArea;
    private JTextArea a111999TextArea;
    private JTextArea a332020TextArea;
    private JButton deleteEmployeeButton;
    private JPanel secondPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DeleteEmployee");
        frame.setContentPane(new DeleteEmployee().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

