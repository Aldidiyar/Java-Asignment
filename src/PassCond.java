import java.util.regex.Pattern;

public class PassCond implements CondForPass {
    @Override
    public boolean isValidPass(String string){
        boolean isValidPass = false;
         final String passCond = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
                "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
                "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
                "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
                "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
                "{6,32}$";
        final Pattern PASSWORD_PATTERN = Pattern.compile(passCond);
        for(int i = 0; i < string.length(); i++){
            if(PASSWORD_PATTERN.matcher(string).matches()){
                isValidPass = true;
            }
        }
        return isValidPass;
    }
}
