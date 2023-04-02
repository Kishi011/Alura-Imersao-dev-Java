package exceptions;
public class TipoDeConteudoInvalidoException extends Exception {
    
    public TipoDeConteudoInvalidoException(String message) {
        super("\u001b[31m" + message + "\u001b[0m");
    }
}
