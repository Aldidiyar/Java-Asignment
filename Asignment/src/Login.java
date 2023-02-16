import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
public class Login extends Autorization{
    @Override
    protected void SignIn(String loginOrIin, Autorization autorization) throws SQLException {
        try {
            if (ifLoginExists(loginOrIin)) {
                System.out.println("Enter password:");
                password = s.nextLine();
                if (autorization.ifLoginLogins(loginOrIin, password)) {
                    System.out.println("You have logged in succesfully");
                } else {
                    System.out.println("Wrong password");
                }
            } else {
                System.out.println("Wrong username");
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
