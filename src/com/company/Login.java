package com.company;
import com.jdbc.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JPanel rootPanel;
    private JPanel secondPanel;
    private String username = "admin";
    private String password = "4f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb"; //user
    private static JFrame frame;


    public Login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    credentials();
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                }
            }
        });
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        credentials();
                    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                        noSuchAlgorithmException.printStackTrace();
                    }
                }
            }
        });
    }

    public void credentials() throws NoSuchAlgorithmException{
        String s = new String(passwordField1.getPassword()); //Arrays.equals(password.toCharArray(), passwordField1.getPassword())
            if(textField1.getText().equals(username) && password.equals(toHexString(getSHA(s)))){

                Dashboard.main(new String[0]);
                //frame.setVisible(false); //hides
                frame.dispose(); //deletes
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password or Username");
            }

    }



    public static void main(String[] args) throws Exception {
        frame = new JFrame("Login");
        frame.setContentPane(new Login().rootPanel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        DbController.getInstance();

    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

}
