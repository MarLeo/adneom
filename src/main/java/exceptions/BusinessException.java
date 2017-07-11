package exceptions;

public class BusinessException extends Exception{

    public BusinessException() {}

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }



}
