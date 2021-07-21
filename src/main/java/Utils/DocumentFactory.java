package Utils;

import Entities.Task;
import Entities.Outgoing;
import Entities.Incoming;
import Entities.Person;
import Entities.Document;
import Enums.DocumentType;
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

    public DocumentFactory(List<String> texts, List<Person> people, List<String> deliveryMethods){
        this.texts = texts;
        this.people = people;
        this.deliveryMethods = deliveryMethods;
    }

    //Заполняем документы из заранее подгтовленных листов и случайных значений
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
