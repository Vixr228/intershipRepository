package Utils;

import Entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

public class DocumentFactory{

    private static Logger logger;
    private Randomizer rand;
    private List<String> texts;
    private List<Employee> employees;
    private List<String> deliveryMethods;

    public DocumentFactory(List<String> texts, List<Employee> employees, List<String> deliveryMethods){
        logger = LogManager.getRootLogger();
        rand = new Randomizer();
        this.texts = texts;
        this.employees = employees;
        this.deliveryMethods = deliveryMethods;
    }

    //Заполняем документы из заранее подгтовленных листов и случайных значений
    public Document createDocument(Class<?> classDoc){
        Document document = null;

        switch (classDoc.getSimpleName()){
            case "Task":
                document = new Task(rand.randomId(),"", texts.get(rand.randomNum(texts.size())), new Date(),
                        employees.get(rand.randomNum(employees.size())), rand.randomDate(), rand.randomDate(),
                        employees.get(rand.randomNum(employees.size())), "Оно работает", employees.get(rand.randomNum(employees.size())));
                document.setName("Task " + document.getRegistrationNumber());
                break;
            case "Incoming":
                document = new Incoming(rand.randomId(),"", texts.get(rand.randomNum(texts.size())), new Date(),
                        employees.get(rand.randomNum(employees.size())), employees.get(rand.randomNum(employees.size())),
                        employees.get(rand.randomNum(employees.size())), rand.randomOutgoingNumber(), rand.randomDate());
                document.setName("Incoming " + document.getRegistrationNumber());
                break;
            case "Outgoing":
                document = new Outgoing(rand.randomId(),"", texts.get(rand.randomNum(texts.size())), new Date(),
                        employees.get(rand.randomNum(employees.size())), employees.get(rand.randomNum(employees.size())), deliveryMethods.get(rand.randomNum(deliveryMethods.size())));
                document.setName("Outgoing " + document.getRegistrationNumber());
                break;
        }

        logger.info("Создали документ типа: " + document.getClass() + " c номером " + document.getRegistrationNumber());
        return document;
    }


}
