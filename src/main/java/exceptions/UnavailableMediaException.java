package exceptions;

public class UnavailableMediaException extends Exception {
    public UnavailableMediaException(String message) {
        super(message);
    }

    public UnavailableMediaException(String message, Throwable throwable) {
        super(message, throwable);
    }

}