package com.company;

import com.models.OrderController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class UpdateOrder {
    private JPanel rootPanel;
    private JButton returnButton;
    private JButton saveButton;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_quantity;
    private JTextField tf_orderdate;
    private JTextField tf_url;
    private JCheckBox status_checkbox;
    private static JFrame frame;
    private boolean status;

    public UpdateOrder() {
        OrderController orderController = new OrderController();

        tf_id.setEditable(false);
        tf_id.setText(String.valueOf(ListOrder.selected_order.getId()));
        tf_name.setText(ListOrder.selected_order.getName());
        tf_quantity.setText(String.valueOf(ListOrder.selected_order.getQuantity()));
        tf_orderdate.setText(String.valueOf(ListOrder.selected_order.getOrderdate()));
        tf_url.setText(ListOrder.selected_order.getUrl());
        status_checkbox.setSelected(ListOrder.selected_order.getStatus());

        status_checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (status_checkbox.isSelected()) {
                    status = true;
                } else {
                    status = false;
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opt = JOptionPane.showConfirmDialog(frame, "Are you sure you want to save edit?", "Warning", JOptionPane.YES_NO_OPTION);
                frame.dispose();
                if (opt == JOptionPane.YES_OPTION) {

                    try {
                        orderController.updateOrder(ListOrder.selected_order.getId(), tf_name.getText(), Integer.parseInt(tf_quantity.getText()), Date.valueOf(tf_orderdate.getText()), tf_url.getText(), status);
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (IllegalArgumentException err) {
                        JOptionPane.showMessageDialog(frame, "Please enter all required information correctly!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    ListOrder.main(new String[0]);
                    frame.dispose();
                } else if (opt == JOptionPane.NO_OPTION) {
                    UpdateOrder.main(new String[0]);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOrder.main(new String[0]);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Update Order");
        frame.setContentPane(new UpdateOrder().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ImageIcon img = new ImageIcon("VWZ_icon.png");
        frame.setIconImage(img.getImage());
    }
}
