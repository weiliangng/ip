package exception;

public class BlarneyException extends RuntimeException {
    public BlarneyException(String message) { super("error occured: " + message); }
    public BlarneyException(String message, Throwable cause) { super("error occured: " + message, cause); }
    public BlarneyException(Throwable cause) { super("error occured: ", cause); }

}
