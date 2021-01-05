package com.company;

import com.models.Product;
import com.models.ProductController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class UpdateProduct {
    private JPanel rootPanel;
    private JButton saveButton;
    private JButton deleteButton;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_quantity;
    private JTextField tf_entrydate;
    private JButton returnButton;
    private static JFrame frame;

    private Product selected_product = ListProduct.selected_product;

    public UpdateProduct() {
        ProductController productController = new ProductController();

        //Take ID and information from listproduct
        tf_id.setEditable(false);
        tf_id.setText(String.valueOf(selected_product.getId()));
        tf_name.setText(selected_product.getName());
        tf_quantity.setText(String.valueOf(selected_product.getQuantity()));
        tf_entrydate.setText(String.valueOf(selected_product.getEntrydate()));
        

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to save edit?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.dispose();
                if (opt == JOptionPane.YES_OPTION) {

                    try {
                        productController.updateProduct(selected_product.getId(), tf_name.getText(), Integer.parseInt(tf_quantity.getText()), Date.valueOf(tf_entrydate.getText()));
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (IllegalArgumentException err) {
                        JOptionPane.showMessageDialog(frame, "Please enter all required information correctly!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    ListProduct.main(new String[0]);
                    frame.dispose();
                } else if (opt == JOptionPane.NO_OPTION) {
                    UpdateProduct.main(new String[0]);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this Product?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.dispose();
                if (opt == JOptionPane.YES_OPTION) {

                    try {
                        productController.deleteProduct(ListProduct.selected_product.getId());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(frame, "Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
                    ListProduct.main(new String[0]);
                } else if (opt == JOptionPane.NO_OPTION) {
                    UpdateProduct.main(new String[0]);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListProduct.main(new String[0]);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Update Product");
        frame.setContentPane(new UpdateProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("resources/vwz_icon.png").getImage());
    }
}
