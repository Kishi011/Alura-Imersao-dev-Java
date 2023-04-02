package exceptions;
public class TipoDeConteudoInvalidoException extends Exception{
    
    public TipoDeConteudoInvalidoException(String s) {
        System.out.println("\u001b[31m" + "TipoDeConteudoInvalidoException: " + s + "\u001b[0m");
    }
}
