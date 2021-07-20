package Entities;
import Utils.DocumentExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Objects;

public abstract class Document implements Comparable<Document>{
    public static Logger logger = LogManager.getRootLogger();
    private static int documentCounter = 1;

    private int id;
    private String name;
    private String text;
    private int registrationNumber;
    private Date registrationDate;
    private Employee author;

    private int prevRegistrationNumber = 0;

    public Document(){}
    public Document(int id, String name, String text, Date registrationDate, Employee author){
        this.id = id;
        this.name = name;
        this.text = text;
        if(prevRegistrationNumber == documentCounter) try {
            logger.error("Документ с номером " + registrationNumber + " уже существует");
            throw new DocumentExistException("file with this registration number is exist");
        } catch (DocumentExistException e) {
            e.printStackTrace();
        }
        prevRegistrationNumber = documentCounter;
        this.registrationNumber = documentCounter++;
        this.registrationDate = registrationDate;
        this.author = author;
        logger.info("Создали новый документ с номером " + registrationNumber);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id && registrationNumber == document.registrationNumber && prevRegistrationNumber == document.prevRegistrationNumber && name.equals(document.name) && text.equals(document.text) && registrationDate.equals(document.registrationDate) && author.equals(document.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, registrationNumber, registrationDate, author, prevRegistrationNumber);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", registrationNumber=" + registrationNumber +
                ", registrationDate=" + registrationDate +
                ", author=" + author +
                ", prevRegistrationNumber=" + prevRegistrationNumber +
                '}';
    }

    public abstract String printDocument();
}
