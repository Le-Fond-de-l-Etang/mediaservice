package exceptions;

public class AllMusicsAlreadyReturnedException extends Exception {
    public AllMusicsAlreadyReturnedException(String message) {
        super(message);
    }

    public AllMusicsAlreadyReturnedException(String message, Throwable throwable) {
        super(message, throwable);
    }

}