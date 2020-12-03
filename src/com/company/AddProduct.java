package com.company;

import com.jdbc.Product;
import com.jdbc.VWZDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AddProduct {
    private JPanel rootPanel;
    private JButton saveProductInformationButton;
    private JTextField tf_quantity;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_entrydate;
    private JPanel secondPanel;
    private JLabel dateOfEntryLabel;
    private JLabel quantityLabel;
    private JLabel productNameLabel;
    private JLabel productIDLabel;
    private static JFrame frame;
    private List<Product> productlist;

    public AddProduct() {
        saveProductInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send DATA
                VWZDao vwzDao = new VWZDao();

                try {
                    vwzDao.init();

                    //Product product = new Product(3,"Apple",2, Date.valueOf("2020-12-03"));
                    Date date = Date.valueOf(tf_entrydate.getText());
                    Product entryproduct = new Product(Integer.parseInt(tf_id.getText()), tf_name.getText(), Integer.parseInt(tf_quantity.getText()), date);
                    vwzDao.insertProductData(entryproduct);
                    productlist = vwzDao.loadProduct();
                    productlist.stream().forEach(products -> {
                        System.out.println(products.toString());
                    });
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
        frame.setContentPane(new AddProduct().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
