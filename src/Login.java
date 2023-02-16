import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.regex.Pattern;
public class Login extends Autorization{
    @Override
    protected void SignIn(String loginOrIin, Autorization autorization) throws SQLException {
        int [] time = {5000, 30000, 60000};
        int tries, count = 0;
        String[] timerMessage = {"5 sec", "30 sec", "1 minute"};
        try {
            if (ifLoginExists(loginOrIin)) {
                System.out.println("Enter password:");
                password = s.nextLine();
                String newPassword;
                for (int i = 0; i < 3; i++) {
                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        byte[] hash = md.digest(password.getBytes());
                        newPassword = Base64.getEncoder().encodeToString(hash);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    if (autorization.ifLoginLogins(loginOrIin, newPassword)) {
                        System.out.println("You have logged in successfully");
                        break;
                    } else {
                        System.out.println("Wrong password, you can try again in " + timerMessage[i]);
                        Thread.sleep(time[i]);
                        tries = 3 -i;
                        if (tries > 1) { System.out.println("Try again. You've got " + tries+ " tries");}
                        else {
                            System.out.println("Try again. You've got " + tries+ " try");
                        }
                        password = s.nextLine();
                        count++;
                    }

                }
                if (count == 3) {
                    System.out.println("No more tries");
                }
            } else {
                System.out.println("Wrong username");
            }
        } catch(SQLException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}