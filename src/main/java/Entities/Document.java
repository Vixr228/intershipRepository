package Entities;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public abstract class Document implements Comparable<Document>{
    public static Logger logger;


    private static int documentCounter = 1;
    private int id;
    private String name;
    private String text;
    private int registrationNumber;
    private Date registrationDate;
    private Employee author;

    private int prevRegistrationNumber = 0;

    public Document(){}
    public Document(String name, String text, Date registrationDate, Employee author){
        logger = LogManager.getRootLogger();
        this.name = name;
        this.text = text;
        this.registrationDate = registrationDate;
        this.author = author;
        this.id = (int) Math.random() * 1000;
        if(prevRegistrationNumber == documentCounter) try {
            logger.error("Такой документ уже существует");
            throw new DocumentExistException("file with this registration number is exist");
        } catch (DocumentExistException e) {
            e.printStackTrace();
        }
        prevRegistrationNumber = documentCounter;
        this.registrationNumber = documentCounter++;
        logger.info("Создали новый документ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    @Override
    public int compareTo(Document secondDoc) {
        if(id - secondDoc.id != 0) return id - secondDoc.id;
        return registrationDate.compareTo(secondDoc.registrationDate);
    }


}
