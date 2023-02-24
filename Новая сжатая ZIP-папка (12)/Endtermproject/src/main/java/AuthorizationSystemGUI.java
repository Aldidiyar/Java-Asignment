import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AuthorizationSystemGUI extends JFrame {
    JButton button1 = new JButton("Signup");
    JButton button2 = new JButton("Signin");
    JTextField loginField = new JTextField();
    JLabel loginLabel = new JLabel("login: ");
    JTextField iinField = new JTextField();
    JLabel iinLabel = new JLabel("IIN: ");
    JTextField passwordField = new JTextField();
    JLabel passwordLabel = new JLabel("password: ");

    public AuthorizationSystemGUI() {
        super("Authorisation");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(3);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(this.button1);
        this.button1.addActionListener(new ButtonEventListener());
        container.add(this.button2);
        this.button2.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        ButtonEventListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == AuthorizationSystemGUI.this.button1) {
                SignUpGUI signUp = new SignUpGUI();
                signUp.setVisible(true);
            } else if (e.getSource() == AuthorizationSystemGUI.this.button2) {
                SignInGUI signIn = new SignInGUI();
                signIn.setVisible(true);
            }

        }
    }
}
