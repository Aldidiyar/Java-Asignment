public class CondForIin implements condForId{
    @Override
    public boolean isDigits(String string) {
        boolean isDigit = true;
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }
}
