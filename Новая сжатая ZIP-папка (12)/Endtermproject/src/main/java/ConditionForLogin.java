public class ConditionForLogin implements CondForLog {
    public ConditionForLogin() {
    }

    public boolean isSymbol(String string) {
        boolean isSymbol = false;

        for(int i = 0; i < string.length(); ++i) {
            if (string.contains("@gmail.com")) {
                isSymbol = true;
            }
        }

        return isSymbol;
    }
}
