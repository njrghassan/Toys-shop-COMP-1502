package exceptions;

public class NumberException extends Exception{

    public NumberException(String message) {
        super("Price can not be negative.");
    }
}
