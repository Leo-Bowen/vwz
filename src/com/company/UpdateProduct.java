package com.company;

import com.models.Product;
import com.models.ProductController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProduct {
    private JPanel rootPanel;
    private JPanel secondPanel;
    private JButton saveAndCloseProductButton;
    private JButton deleteProductButton;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_quantity;
    private JTextField tf_entrydate;
    private JLabel productIDLabel;
    private JLabel productNameLabel;
    private JLabel productQuantityLabel;
    private JLabel productEntryDateLabel;
    private static JFrame frame;

    public UpdateProduct() {
        ProductController productController = new ProductController();

        //productController.loadProduct();
        tf_id.setText("");
        tf_name.setText("");
        tf_quantity.setText("");
        tf_entrydate.setText("");

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
