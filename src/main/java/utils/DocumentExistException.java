package utils;

/**
 * Exception - ошибка, такой документ уже существует
 */
public class DocumentExistException extends Exception{
    public DocumentExistException(String errorMessage) {
        super(errorMessage);
    }
}
