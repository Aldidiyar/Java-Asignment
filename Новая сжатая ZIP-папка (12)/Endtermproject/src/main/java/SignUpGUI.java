import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class SignUpGUI extends JFrame {
    JTextField loginField = new JTextField();
    JLabel loginLabel = new JLabel("login: ");
    JTextField iinField = new JTextField();
    JLabel iinLabel = new JLabel("IIN: ");
    JTextField passwordField = new JTextField();
    JLabel passwordLabel = new JLabel("password: ");
    JButton button1 = new JButton("Confirm");
    Autorization auth = new Autorization();

    public SignUpGUI() {
        super("Signup");
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(3);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 1, 2, 2));
        container.add(this.loginLabel);
        container.add(this.loginField);
        container.add(this.iinLabel);
        container.add(this.iinField);
        container.add(this.passwordLabel);
        container.add(this.passwordField);
        this.button1.addActionListener(new ButtonEventListener());
        container.add(this.button1);
    }

    class ButtonEventListener implements ActionListener {
        ButtonEventListener() {
        }

        public void actionPerformed(ActionEvent e) {
            try {
                String message = SignUpGUI.this.auth.SignUp(SignUpGUI.this.loginField.getText(), SignUpGUI.this.iinField.getText(), SignUpGUI.this.passwordField.getText());
                JOptionPane.showMessageDialog((Component)null, message, "Output", -1);
                SignUpGUI.this.setDefaultCloseOperation(2);
            } catch (SQLException var3) {
                throw new RuntimeException(var3);
            } catch (NoSuchAlgorithmException var4) {
                throw new RuntimeException(var4);
            }
        }
    }
}
