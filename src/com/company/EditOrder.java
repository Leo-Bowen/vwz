package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditOrder {
    private JPanel panel1;
    private JTextArea originalProductMaxiglanzGeschirrspülmittelTextArea;
    private JTextArea a0001TextArea;
    private JTextArea a100TextArea;
    private JTextArea maxiglanzSanitärprodukteGmbHTextArea;
    private JButton saveAndCloseOrderButton;
    private JPanel secondaryPanel;

    public EditOrder() {
        saveAndCloseOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EditOrderings");
        frame.setContentPane(new EditOrder().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
