package exceptions;

public class MediaNotFoundException extends Exception {
    public MediaNotFoundException(String message) {
        super(message);
    }

    public MediaNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}