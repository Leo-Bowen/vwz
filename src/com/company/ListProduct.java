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
    private JPanel secondPanel;
    private JButton updateButton;
    private JButton returnButton;
    private JTable productTable;
    private static JFrame frame;

    public static Product selected_product;

    public ListProduct() {
        ProductController productController = new ProductController();

        try {
            productController.loadProduct(productTable);
            productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = productTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Select a product first!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    selected_product = new Product(
                            Integer.parseInt(productTable.getModel().getValueAt(row, 0).toString()),
                            productTable.getModel().getValueAt(row, 1).toString(),
                            Integer.parseInt(productTable.getModel().getValueAt(row, 2).toString()),
                            Date.valueOf(productTable.getModel().getValueAt(row, 3).toString()));
                    UpdateProduct.main(new String[0]);
                    frame.dispose();
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard.main(new String[0]);
                frame.dispose();
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
