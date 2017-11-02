package exceptions;

public class MediaAlreadyReturnedException extends Exception {
    public MediaAlreadyReturnedException(String message) {
        super(message);
    }

    public MediaAlreadyReturnedException(String message, Throwable throwable) {
        super(message, throwable);
    }

}