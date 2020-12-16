package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProduct {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JButton deleteProductButton;
    private JTextField textField1;
    private static JFrame frame;

    public DeleteProduct() {
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListProduct.main(new String[0]);
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "Employee successfully deleted!");
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("DeleteProduct");
        frame.setContentPane(new DeleteProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
