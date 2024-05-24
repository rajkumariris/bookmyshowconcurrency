package Exceptions;

public class InvalidShowException extends RuntimeException{
    public InvalidShowException(String errorMessage){
        super(errorMessage);
    }
}
