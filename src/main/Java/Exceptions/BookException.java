package Exceptions;

public class BookException extends Exception {
    private String message;
    private Throwable throwable;

    public BookException(String message, Throwable throwable1) {
        super(message, throwable1);
        this.message = message;
        this.throwable = throwable1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
