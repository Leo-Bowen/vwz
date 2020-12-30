package com.company;

import com.models.Product;
import com.models.ProductController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class ListProduct {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JButton updateButton;
    private JButton returnButton;
    private JTable producttable;
    private static JFrame frame;

    public static Product selected_product;

    public ListProduct() {
        ProductController productController = new ProductController();

        try {
            productController.loadProduct(producttable);
            producttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = producttable.getSelectedRow();
                selected_product = new Product(
                        Integer.parseInt(producttable.getModel().getValueAt(row, 0).toString()),
                        producttable.getModel().getValueAt(row, 1).toString(),
                        Integer.parseInt(producttable.getModel().getValueAt(row, 2).toString()),
                        Date.valueOf(producttable.getModel().getValueAt(row, 3).toString()));

                UpdateProduct.main(new String[0]);
                frame.setVisible(false);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.main(new String[0]);
                frame.setVisible(false);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
