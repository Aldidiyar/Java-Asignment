import java.sql.SQLException;
import java.util.regex.Pattern;
public class Iin extends Autorization{
    @Override
    protected void SignIn(String loginOrIin, Autorization autorization) throws SQLException {
        try {
            if (ifIinExists(loginOrIin)) {
                System.out.println("Enter password:");
                password = s.nextLine();
                if (autorization.ifIinLogins(loginOrIin, password)) {
                    System.out.println("You have logged in succesfully");
                }
                else {
                    System.out.println("Wrong password");
                }
            }
            else{
                System.out.println("Wrong IIN");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
