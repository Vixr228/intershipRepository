import Entities.*;
import Enums.DocumentType;
import Utils.Randomizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

public class DocumentFactory{

    private static Logger logger;
    private Randomizer rand;
    private List<String> texts;
    private List<Employee> employees;
    private List<String> names;

    public DocumentFactory(List<String> texts, List<Employee> employees){
        logger = LogManager.getRootLogger();
        rand = new Randomizer();
        this.texts = texts;
        this.employees = employees;
    }

    public Document createDocument(DocumentType documentType){
        Document document = null;

        switch (documentType){
            case TASK:
                document = new Task("", texts.get(rand.randomNum(texts.size())), new Date(),
                        employees.get(rand.randomNum(employees.size())), rand.randomDate(), rand.randomDate(),
                        employees.get(rand.randomNum(employees.size())), " ", employees.get(rand.randomNum(employees.size())));
                document.setName("Task " + document.getRegistrationNumber());
                break;
            case INCOMING:
                document = new Incoming("", texts.get(rand.randomNum(texts.size())), new Date(),
                        employees.get(rand.randomNum(employees.size())), employees.get(rand.randomNum(employees.size())),
                        employees.get(rand.randomNum(employees.size())), " ", rand.randomDate());
                document.setName("Incoming " + document.getRegistrationNumber());
                break;
            case OUTGOING:
                document = new Outgoing("", texts.get(rand.randomNum(texts.size())), new Date(),
                        employees.get(rand.randomNum(employees.size())), employees.get(rand.randomNum(employees.size())), " ");
                document.setName("Outgoing " + document.getRegistrationNumber());
                break;
        }

        logger.info("Создали документ типа: " + documentType);
        return document;
    }


}
