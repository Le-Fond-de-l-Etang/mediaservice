package exceptions;

public class MusicNotFoundException extends Exception {
    public MusicNotFoundException(String message) {
        super(message);
    }

    public MusicNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}