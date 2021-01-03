package com.company;

import com.models.Order;
import com.models.OrderController;
import com.models.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

public class ListOrder {
    private JPanel rootPanel;
    private JButton updateButton;
    private JButton returnButton;
    private JTable orderTable;
    private JTextField tf_search;
    private static JFrame frame;

    public static Order selected_order;

    public ListOrder() {
        OrderController orderController = new OrderController();

        try {
            orderController.loadOrder(orderTable);
            orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        orderController.searchOrder(orderTable, tf_search.getText());
                    } catch (ClassNotFoundException | SQLException Exception) {
                        Exception.printStackTrace();
                    } catch (PatternSyntaxException patternSyntaxException) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid Syntax!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = orderTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Select a product first!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    selected_order = new Order(
                            Integer.parseInt(orderTable.getModel().getValueAt(row, 0).toString()),
                            orderTable.getModel().getValueAt(row, 1).toString(),
                            Integer.parseInt(orderTable.getModel().getValueAt(row, 2).toString()),
                            Date.valueOf(orderTable.getModel().getValueAt(row, 3).toString()), orderTable.getModel().getValueAt(row, 4).toString(), (Boolean) orderTable.getModel().getValueAt(row, 5));
                    UpdateOrder.main(new String[0]);
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
        frame = new JFrame("Order List");
        frame.setContentPane(new ListOrder().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ImageIcon img = new ImageIcon("VWZ_icon.png");
        frame.setIconImage(img.getImage());
    }
}
