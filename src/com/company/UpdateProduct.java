package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProduct {
    private JPanel rootPanel;
    private JButton saveAndCloseProductButton;
    private JTextArea maxiGlanzGeschirrspülmittelTextArea;
    private JTextArea a00001TextArea;
    private JTextArea dishSoapTextArea;
    private JTextArea a250TextArea1;
    private JPanel secondPanel;
    private JButton deleteProductButton;
    private static JFrame frame;

    public UpdateProduct() {
        saveAndCloseProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                ListProduct.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this Product?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.setVisible(false);
                if (opt == JOptionPane.YES_OPTION) {
                    ListProduct.main(new String[0]);
                } else if (opt == JOptionPane.NO_OPTION){
                    UpdateProduct.main(new String[0]);
                }
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("SeeProductStock");
        frame.setContentPane(new UpdateProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
