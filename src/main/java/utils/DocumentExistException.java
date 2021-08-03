package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Exception - ошибка, такой документ уже существует
 */
public class DocumentExistException extends Exception{
    public static Logger logger = LogManager.getRootLogger();
    public DocumentExistException(String errorMessage, int registrationNumber) {
        super(errorMessage);
        logger.error("Документ с номером " + registrationNumber + " уже существует");
    }
}
