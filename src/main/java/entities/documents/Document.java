package entities.documents;
import entities.orgstuff.Person;
import utils.DocumentExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.XMLConverter;

import java.io.FileWriter;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public abstract class Document implements Comparable<Document>, XMLConverter {

    private static int documentCounter = 1;

    private UUID id;
    private String name;
    private String text;
    private int registrationNumber;
    private Date registrationDate;
    private Person author;

    private transient int prevRegistrationNumber = 0;

    public Document(){}
    /**
     * Конструктор - создание нового документа с заданными параметрами. С проверкой на уже существующий регистрационный номер.
     * @param id - id документа
     * @param name - Название документа
     * @param text - текстовое описание
     * @param registrationDate - дата создания
     * @param author - автор документа
     *
     */
    public Document(UUID id, String name, String text, Date registrationDate, Person author){
        this.id = id;
        this.name = name;
        this.text = text;
        if(prevRegistrationNumber == documentCounter) {
            try {
                throw new DocumentExistException("file with this registration number is exist", registrationNumber);
            } catch (DocumentExistException e) {
                e.printStackTrace();
            }
        }
        prevRegistrationNumber = documentCounter;
        this.registrationNumber = documentCounter++;
        this.registrationDate = registrationDate;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Document{");
        sb.append("id=" + id);
        sb.append(", name=" + name);
        sb.append(", text=" + text);
        sb.append(", registrationNumber=" + registrationNumber);
        sb.append(", registrationDate=" + registrationDate);
        sb.append(", author=" + author);
        sb.append('}');
        return sb.toString();
    }
    public abstract String printDocument();

    @Override
    public int compareTo(Document secondDoc) {
        if(registrationNumber - secondDoc.registrationNumber != 0) return registrationNumber - secondDoc.registrationNumber;
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
    public StringBuffer convertDocumentToXml(){
        StringBuffer str = new StringBuffer();
        str.append("\t\t<id>" + id + "</id>\n");
        str.append("\t\t<name>" + name + "</name>\n");
        str.append("\t\t<text>" + text + "</text>\n");
        str.append("\t\t<registrationNumber>" + registrationNumber + "</registrationNumber>\n");
        str.append("\t\t<registrationDate>" + registrationDate + "</registrationDate>\n");
        str.append("\t\t<author>\n");
        str.append("\t\t\t<id>" + author.getId() + "</id>\n");
        str.append("\t\t\t<name>" + author.getName() + "</name>\n");
        str.append("\t\t\t<surname>" + author.getSurname() + "</surname>\n");
        str.append("\t\t\t<patronymic>" + author.getPatronymic() + "</patronymic>\n");
        str.append("\t\t\t<position>" + author.getPosition() + "</position>\n");
        str.append("\t\t\t<birthDate>" + author.getBirthDate() + "</birthDate>\n");
        str.append("\t\t\t<phoneNumber>\n");
        str.append("\t\t\t\t<number>" + author.getPhoneNumber().getNumber() + "</number>\n");
        str.append("\t\t\t</phoneNumber>\n");
        str.append("\t\t</author>\n");

        return str;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, registrationNumber, registrationDate, author, prevRegistrationNumber);
    }
}
