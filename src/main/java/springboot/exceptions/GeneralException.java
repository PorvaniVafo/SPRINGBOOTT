package springboot.exceptions;

public class GeneralException extends RuntimeException {

    public GeneralException(String msg) {
        super(msg);
    }
}