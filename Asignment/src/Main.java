import javax.print.attribute.AttributeSetUtilities;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws SQLException {
        Autorization autorization = new Autorization();
        Scanner s = new Scanner(System.in);
        CondForLogin logCond = new CondForLogin();
        CondForIin iinCond = new CondForIin();
        while(true) {
            System.out.println("1. Sign Up 2. Sign In 3. End session");
            String number = s.nextLine();
            if (Objects.equals(number, "1")) {
                autorization.SignUp();
            }
            else if (Objects.equals(number, "2")) {
                System.out.println("Enter login or IIN");
                String loginOrIin = s.nextLine();
                if (loginOrIin.length() == 12 && iinCond.isDigits(loginOrIin)) {
                    Iin iin = new Iin();
                    iin.SignIn(loginOrIin, autorization);
                }
                if(logCond.isSymbol(loginOrIin)) {
                    Login login = new Login();
                    login.SignIn(loginOrIin, autorization);
                }
                if(!logCond.isSymbol(loginOrIin) && !iinCond.isDigits(loginOrIin)){
                    System.out.println("Wrong Login or IIN");
                }
            }
            else if(Objects.equals(number, "3")){
                break;
            }
        }
    }
}