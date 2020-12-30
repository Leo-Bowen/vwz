package com.company;

import com.models.Product;
import com.models.ProductController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ListProduct {
    private JPanel rootPanel;
    private JPanel secondaryPanel;
    private JButton CloseButton;
    private JButton updateThisProductButton;
    private JTable producttable;
    private static JFrame frame;

    public ListProduct() {
        ProductController productController = new ProductController();

        try {
            producttable = productController.loadProduct(producttable);
            producttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        producttable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                DefaultTableModel DTM = (DefaultTableModel) producttable.getModel();
                System.out.println(DTM.getDataVector().elementAt(producttable.getSelectedRow()));
            }
        });

        updateThisProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProduct.main(new String[0]);
                frame.setVisible(false);
            }
        });
        CloseButton.addActionListener(new ActionListener() {
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
