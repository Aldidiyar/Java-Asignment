import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;


public  class Autorization {
    PassCond passCond = new PassCond();
    CondForIin iinCond = new CondForIin();
    CondForLogin logCond = new CondForLogin();
    String login;
    String iin;
    String password;
    Scanner s = new Scanner(System.in);

    protected boolean ifLoginExists(String login) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT login FROM users WHERE login = '" + login + "')\n" +
                "THEN CAST(1 as bool)\n" +        "ELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }
    protected boolean ifIinExists(String iin) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT iin FROM users WHERE iin = '" + iin + "')\n" +
                "THEN CAST(1 as bool)\n" +        "ELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }
    protected boolean ifIinLogins(String iin, String password) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT iin, password FROM users WHERE iin = '" + iin + "' and password ='"+password+"')\n" +
                "THEN CAST(1 as bool)\n" +        "ELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }
    protected boolean ifLoginLogins(String login, String password) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT login, password FROM users WHERE login = '" + login + "' and password ='"+password+"')\n" +
                "THEN CAST(1 as bool)\n" +        "ELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }
    protected void addUser(String login, String iin, String password) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Statement statement = connection.createStatement();
        String INSERT_INTO = "INSERT INTO users (login, password, iin) VALUES" + "('" + login + "', '" + password + "','"+iin+"')";
        int result = statement.executeUpdate(INSERT_INTO);
    }
    protected void SignUp() throws SQLException {
        System.out.println("Enter login:");
        while (true){
            login = s.nextLine();
            try {
                if (ifLoginExists(login)) {
                    System.out.println("Login already in use, try another:");
                }
                else if(logCond.isSymbol(login)){
                    break;
                }
                else {
                    System.out.println("Add @gmail.com to your login");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Enter IIN:");
        while ((true)){
            iin = s.nextLine();
            if (ifIinExists(iin)) {
                System.out.println("IIN already in use, try another:");
            } else if(iinCond.isDigits(iin) && iin.length() == 12){
                break;
            }
            else {
                System.out.println("IIN must has 12 digits, no more, no less ");
            }
        }
        System.out.println("Enter password:");
        while (true){
            password = s.nextLine();
            if (passCond.isValidPass(password)) {
                System.out.println("Success");
                addUser(login, iin, password);
                break;
            } else {
                System.out.println("Wrong, try again ");
            }
        }
    }

    protected void SignIn(String loginOrIin, Autorization autorization) throws SQLException {
    }
}

