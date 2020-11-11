import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JPanel rootPanel;
    private String username = "user";
    private String password = "user";
    private static JFrame frame;

    public Login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals(username) && Arrays.equals(password.toCharArray(), passwordField1.getPassword())){

                    Dashboard.main(new String[0]);
                    //frame.setVisible(false); //hides
                    frame.dispose(); //deletes
                }}
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Login");
        frame.setContentPane(new Login().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
