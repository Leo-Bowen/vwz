package com.company;

import com.models.Product;
import com.models.ProductController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class CreateProduct {
    private JPanel rootPanel;
    private JButton saveProductInformationButton;
    private JTextField tf_quantity;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_entrydate;
    private JPanel secondPanel;
    private JLabel productDateOfEntryLabel;
    private JLabel productQuantityLabel;
    private JLabel productNameLabel;
    private JLabel productIDLabel;
    private static JFrame frame;
    private List<Product> productlist;
    private ProductController productController;

    public CreateProduct() {
        saveProductInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                try {
                    //Product product = new Product(3,"Apple",2, Date.valueOf("2020-12-03"));
                    productController = new ProductController();
                    productController.addProduct(tf_name.getText(), Integer.parseInt(tf_quantity.getText()), Date.valueOf(tf_entrydate.getText()));
                } catch (ClassNotFoundException | SQLException err) {
                    err.printStackTrace();
                }
                Dashboard.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AddProduct");
        frame.setContentPane(new CreateProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
