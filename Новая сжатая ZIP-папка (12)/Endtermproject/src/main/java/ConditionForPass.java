import java.util.regex.Pattern;

public class ConditionForPass implements CondForPass {
    public ConditionForPass() {
    }

    public boolean isValidPass(String string) {
        boolean isValidPass = false;
        String passCond = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]{6,32}$";
        Pattern PASSWORD_PATTERN = Pattern.compile("^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]{6,32}$");

        for(int i = 0; i < string.length(); ++i) {
            if (PASSWORD_PATTERN.matcher(string).matches()) {
                isValidPass = true;
            }
        }

        return isValidPass;
    }
}
