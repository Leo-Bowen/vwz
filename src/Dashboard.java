import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    private JPanel rootPanel;
    private JButton editOrderings;
    private JLabel helloLabel;
    private JButton orderProductsButton;
    private JButton editProductButton;
    private JButton addProductButton;
    private JButton editEmployeeButton;
    private JButton addEmployeeButton;

    public Dashboard() {
        editOrderings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dashboard");
        frame.setContentPane(new Dashboard().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
