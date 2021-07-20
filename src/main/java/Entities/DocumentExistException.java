package Entities;

public class DocumentExistException extends Exception{
    public DocumentExistException(String errorMessage) {
        super(errorMessage);
    }
}
