import java.sql.SQLException;

public class Login extends Autorization {
    public Login() {
    }

    protected String SignIn(String loginOrIin, String password, Autorization autorization) throws SQLException {
        try {
            return autorization.ifLoginLogins(loginOrIin, password) ? "You have logged in succesfully" : "Wrong IIN or password";
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }
}
