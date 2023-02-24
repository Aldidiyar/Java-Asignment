//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Autorization {
    ConditionForPass passCond = new ConditionForPass();
    ConditionForIIN iinCond = new ConditionForIIN();
    ConditionForLogin logCond = new ConditionForLogin();
    String login;
    String iin;
    String password;
    Scanner s;

    public Autorization() {
        this.s = new Scanner(System.in);
    }

    protected boolean ifLoginExists(String login) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception var6) {
            var6.printStackTrace();
            PrintStream var10000 = System.err;
            String var10001 = var6.getClass().getName();
            var10000.println(var10001 + ": " + var6.getMessage());
            System.exit(0);
        }

        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT login FROM users WHERE login = '" + login + "')\nTHEN CAST(1 as bool)\nELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }

    protected boolean ifIinExists(String iin) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception var6) {
            var6.printStackTrace();
            PrintStream var10000 = System.err;
            String var10001 = var6.getClass().getName();
            var10000.println(var10001 + ": " + var6.getMessage());
            System.exit(0);
        }

        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT iin FROM users WHERE iin = '" + iin + "')\nTHEN CAST(1 as bool)\nELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }

    protected boolean ifIinLogins(String iin, String password) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception var7) {
            var7.printStackTrace();
            PrintStream var10000 = System.err;
            String var10001 = var7.getClass().getName();
            var10000.println(var10001 + ": " + var7.getMessage());
            System.exit(0);
        }

        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT iin, password FROM users WHERE iin = '" + iin + "' and password ='" + password + "')\nTHEN CAST(1 as bool)\nELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }

    protected boolean ifLoginLogins(String login, String password) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception var7) {
            var7.printStackTrace();
            PrintStream var10000 = System.err;
            String var10001 = var7.getClass().getName();
            var10000.println(var10001 + ": " + var7.getMessage());
            System.exit(0);
        }

        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT CASE WHEN  EXISTS(SELECT login, password FROM users WHERE login = '" + login + "' and password ='" + password + "')\nTHEN CAST(1 as bool)\nELSE CAST(0 as bool) end AS existance;");
        res.next();
        boolean result = res.getBoolean("existance");
        return result;
    }

    protected void addUser(String login, String iin, String password) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "2222");
        } catch (Exception var8) {
            var8.printStackTrace();
            PrintStream var10000 = System.err;
            String var10001 = var8.getClass().getName();
            var10000.println(var10001 + ": " + var8.getMessage());
            System.exit(0);
        }

        Statement statement = connection.createStatement();
        String INSERT_INTO = "INSERT INTO users (login, password, iin) VALUES('" + login + "', '" + password + "','" + iin + "')";
        statement.executeUpdate(INSERT_INTO);
    }

    protected String SignUp(String login1, String iin1, String password1) throws SQLException, NoSuchAlgorithmException {
        try {
            if (this.ifLoginExists(login1)) {
                return "Login already in use, try another";
            } else if (!this.logCond.isSymbol(login1)) {
                return "Add @gmail.com to your login";
            } else if (this.ifIinExists(iin1)) {
                return "IIN already in use, try another";
            } else if (this.iinCond.isDigits(iin1) && iin1.length() == 12) {
                if (!this.passCond.isValidPass(password1)) {
                    return "Password must have at least one capital letter and digit";
                } else {
                    this.addUser(login1, iin1, password1);
                    return "You have registered succesfully";
                }
            } else {
                return "IIN must has 12 digits, no more, no less ";
            }
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    protected void SignIn(String loginOrIin, Autorization autorization) throws SQLException {
    }
}