//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignInGUI extends JFrame {
    JTextField loginOrIinField = new JTextField();
    JLabel loginOrIinLabel = new JLabel("login or IIN: ");
    JTextField passwordField = new JTextField();
    JLabel passwordLabel = new JLabel("password: ");
    JButton button1 = new JButton("Confirm");
    Autorization auth = new Autorization();
    ConditionForIIN iinCond = new ConditionForIIN();

    public SignInGUI() {
        super("Signin");
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(3);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 1, 2, 2));
        container.add(this.loginOrIinLabel);
        container.add(this.loginOrIinField);
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
                String message;
                if (SignInGUI.this.loginOrIinField.getText().length() == 12 && SignInGUI.this.iinCond.isDigits(SignInGUI.this.loginOrIinField.getText())) {
                    IIN iin = new IIN();
                    message = iin.SignIn(SignInGUI.this.loginOrIinField.getText(), SignInGUI.this.passwordField.getText(), SignInGUI.this.auth);
                    JOptionPane.showMessageDialog((Component)null, message, "Output", -1);
                    SignInGUI.this.setDefaultCloseOperation(2);
                } else {
                    Login login = new Login();
                    message = login.SignIn(SignInGUI.this.loginOrIinField.getText(), SignInGUI.this.passwordField.getText(), SignInGUI.this.auth);
                    JOptionPane.showMessageDialog((Component)null, message, "Output", -1);
                    SignInGUI.this.setDefaultCloseOperation(2);
                }

            } catch (SQLException var4) {
                throw new RuntimeException(var4);
            }
        }
    }
}
