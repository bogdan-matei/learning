package exception;

// The custom exception we created for our Alchemy process
public class ConversionException extends Exception {
    public ConversionException() {
        super("You don't have the necessary resources to do that!");
    }
}
