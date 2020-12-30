package com.company;

import com.models.ProductController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class CreateProduct {
    private JPanel rootPanel;
    private JPanel secondPanel;
    private JButton saveButton;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_quantity;
    private JTextField tf_entrydate;
    private JLabel productIDLabel;
    private JLabel productNameLabel;
    private JLabel productQuantityLabel;
    private JLabel productEntryDateLabel;
    private JButton returnButton;
    private static JFrame frame;

    public CreateProduct() {
        ProductController productController = new ProductController();

        tf_id.setEditable(false);
        tf_id.setText("ID will automatically be set by database");
        tf_entrydate.setText(productController.getDate());

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    productController.addProduct(tf_name.getText(), Integer.parseInt(tf_quantity.getText()), Date.valueOf(tf_entrydate.getText()));
                } catch (ClassNotFoundException | SQLException err) {
                    err.printStackTrace();
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(frame, "Please enter all required information correctly!", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                Dashboard.main(new String[0]);
                frame.setVisible(false); //hides
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
        frame = new JFrame("AddProduct");
        frame.setContentPane(new CreateProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
