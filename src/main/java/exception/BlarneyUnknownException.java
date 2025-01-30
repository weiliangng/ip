package exception;

public class BlarneyUnknownException extends BlarneyException {
    public BlarneyUnknownException() {
        super("I don't know what to do with this input, check input syntax");
    }
}
