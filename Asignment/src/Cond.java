public interface Cond {
}

 interface condForId extends Cond {
     public boolean isDigits(String string);
}
interface CondForLog extends Cond{
    public boolean isSymbol(String string);
}
interface CondForPass extends Cond{
    public boolean isValidPass(String string);
}