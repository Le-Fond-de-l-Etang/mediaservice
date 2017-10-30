package exceptions;

public class UnavailableMusicException extends Exception {
    public UnavailableMusicException(String message) {
        super(message);
    }

    public UnavailableMusicException(String message, Throwable throwable) {
        super(message, throwable);
    }

}