import Entities.*;

import java.util.Date;
import java.util.List;

public class DocumentFactory {

    private static int documentCounter = 0;
    private List<String> texts;
    private List<Employee> employees;
    private List<Date> dates;
    private List<String> names;

    public DocumentFactory(List<String> texts, List<Employee> employees, List<Date> dates, List<String> names){
        this.texts = texts;
        this.employees = employees;
        this.dates = dates;
        this.names = names;
    }

    public Document createDocument(DocumentType documentType){
        Document document = null;

        switch (documentType){
            case TASK:
                document = new Task(names.get(documentCounter), texts.get(documentCounter), new Date(),
                        employees.get(documentCounter), dates.get(documentCounter), dates.get(documentCounter + 1),
                        employees.get(documentCounter + 1), " ", employees.get(documentCounter + 2));
                break;
            case INCOMING:
                document = new Incoming(names.get(documentCounter), texts.get(documentCounter), new Date(),
                        employees.get(documentCounter), employees.get((int) Math.random() * 5),
                        employees.get((int)(Math.random() * 5)), " ", dates.get(documentCounter));
                break;
            case OUTGOING:
                document = new Outgoing(names.get(documentCounter), texts.get(documentCounter), new Date(),
                        employees.get(documentCounter), employees.get((int) Math.random() * 5), " ");
                break;
        }

        document.setRegistrationNumber(documentCounter++);
        return document;
    }


}
