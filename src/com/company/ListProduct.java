package com.company;

import com.models.Product;
import com.models.ProductController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ListProduct {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JButton saveAndCloseButton;
    private JButton updateThisProductButton;
    private JList list1;
    private static JFrame frame;


    public ListProduct() {
        saveAndCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.main(new String[0]);
                frame.setVisible(false);
            }
        });
        updateThisProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProduct.main(new String[0]);
                frame.setVisible(false);
                ProductController productController = new ProductController();
                try {
                    productController.deleteProduct(4);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        frame = new JFrame("ListProduct");
        frame.setContentPane(new ListProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
