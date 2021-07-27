package utils;

import entities.documents.Task;
import entities.documents.Outgoing;
import entities.documents.Incoming;
import entities.orgstuff.Person;
import entities.documents.Document;
import enums.DocumentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

public class DocumentFactory{

    private static Logger logger = LogManager.getRootLogger();
    private Randomizer  rand = new Randomizer();
    private List<String> texts;
    private List<Person> people;
    private List<String> deliveryMethods;

    /**
     * Конструктор фабрики, куда передаются заранее подготовленные листы с данными из которых потом формируются документы
     * @param texts - массив для поля текст
     * @param people - массив работников (авторы, исполнители...)
     * @param deliveryMethods - массив с методами доставок (Самолет, поезд, машина, корабль)
     */
    public DocumentFactory(List<String> texts, List<Person> people, List<String> deliveryMethods){
        this.texts = texts;
        this.people = people;
        this.deliveryMethods = deliveryMethods;
    }

    //Заполняем документы из заранее подгтовленных листов и случайных значений

    /**
     * createDocument - метод создания новых документов. Данные у документов заполняються случайным образом из заранее подготовленных листов переденных в конструктор.
     * @param classDoc - класс документа, которые хотим создать
     * @return Document
     */
    public Document createDocument(Class<?  extends Document> classDoc){
        Document document = null;
        DocumentType documentType = DocumentType.getDocumentTypeByClassName(classDoc.getSimpleName());
        switch (documentType){
            case TASK:
                document = new Task(rand.randomId(),"",
                        texts.get(rand.randomNum(texts.size())),
                        new Date(),
                        people.get(rand.randomNum(people.size())),
                        rand.randomDate(), rand.randomDate(),
                        people.get(rand.randomNum(people.size())),
                        "Оно работает",
                        people.get(rand.randomNum(people.size())));
                document.setName(documentType + " " + document.getRegistrationNumber());
                break;
            case INCOMING:
                document = new Incoming(rand.randomId(),"",
                        texts.get(rand.randomNum(texts.size())),
                        new Date(),
                        people.get(rand.randomNum(people.size())),
                        people.get(rand.randomNum(people.size())),
                        people.get(rand.randomNum(people.size())),
                        rand.randomOutgoingNumber(),
                        rand.randomDate());
                document.setName(documentType + " " + document.getRegistrationNumber());
                break;
            case OUTGOING:
                document = new Outgoing(rand.randomId(),"",
                        texts.get(rand.randomNum(texts.size())),
                        new Date(),
                        people.get(rand.randomNum(people.size())),
                        people.get(rand.randomNum(people.size())),
                        deliveryMethods.get(rand.randomNum(deliveryMethods.size())));
                document.setName(documentType + " " + document.getRegistrationNumber());
                break;
        }

        logger.info("Создали документ типа: " + document.getClass() + " c id " + document.getId());
        return document;
    }


}
