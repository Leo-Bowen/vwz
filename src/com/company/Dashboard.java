package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel rootPanel;
    private JButton editOrderButton;
    private JButton addOrderButton;
    private JButton editProductButton;
    private JButton addProductButton;
    private JButton editEmployeeButton;
    private JButton addEmployeeButton;
    private JButton logOutButton;
    private JLabel VWZ;
    private static String mode;
    private static JFrame frame;
    private static int count = 0;

    public Dashboard() {
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkMode()) return;
                CreateEmployee.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkMode()) return;
                ListEmployee.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkMode()) return;
                CreateProduct.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListProduct.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateOrder.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        editOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOrder.main(new String[0]);
                frame.setVisible(false); //hides
            }
        });
        logOutButton.addActionListener(new ActionListener() { //basic logout
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    count = 0;
                    Login.main(new String[0]);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        if (count < 1){
            mode = args[0];
            count++;
        }
        frame = new JFrame("VWZ");
        frame.setContentPane(new Dashboard().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("resources/vwz_icon.png").getImage());
    }


    private void createUIComponents() {
        VWZ = new JLabel(new ImageIcon("resources/avwz.png"));
    }

    private boolean checkMode(){
        if (this.mode.equals("user")){
            JOptionPane.showMessageDialog(frame,"You are not logged in as admin!");
            return true;
        }
        return false;
    }
}
