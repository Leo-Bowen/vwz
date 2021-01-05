package com.company;

import com.models.OrderController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class CreateOrder {
    private JPanel rootPanel;
    private JButton returnButton;
    private JButton saveButton;
    private JTextField tf_id;
    private JTextField tf_name;
    private JTextField tf_quantity;
    private JTextField tf_orderdate;
    private JEditorPane tp_url;
    private JCheckBox status_checkbox;
    private static JFrame frame;
    private boolean status;

    public CreateOrder() {
        OrderController orderController = new OrderController();

        tf_id.setEditable(false);
        tf_id.setText("ID will automatically be set by database");
        tf_orderdate.setText(orderController.getDate());;


        status_checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (status_checkbox.isSelected()){
                    status = true;
                } else {
                    status = false;
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    orderController.addOrder(tf_name.getText(), Integer.parseInt(tf_quantity.getText()), Date.valueOf(tf_orderdate.getText()), tp_url.getText(), status);
                    JOptionPane.showMessageDialog(frame, "Saved Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                    Dashboard.main(new String[0]);
                    frame.dispose();
                } catch (ClassNotFoundException | SQLException err) {
                    err.printStackTrace();
                } catch (IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(frame, "Please enter all required information correctly!", "Warning", JOptionPane.WARNING_MESSAGE);
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
        frame = new JFrame("Create Order");
        frame.setContentPane(new CreateOrder().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("resources/vwz_icon.png").getImage());
    }
}
