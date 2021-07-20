import Entities.Document;
import Entities.DocumentExistException;
import Entities.Employee;
import Enums.DocumentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static Logger logger;
    public static void main(String[] args) throws DocumentExistException {

        logger = LogManager.getRootLogger();
        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("Сергей", "Сергеев", "Сергеевич"));
            add(new Employee("Петр", "Петров", "Петрович"));
            add(new Employee("Антон", "Антонов", "Антонович"));
            add(new Employee("Макс", "Максимов", "Максимович"));
            add(new Employee("Андрей", "Архангелов", "Андреевич"));
            add(new Employee("Сергей", "Бизонов", "Петрович"));
            add(new Employee("Петр", "Потолков", "Андреевич"));
            add(new Employee("Антон", "Ягушев", "Сергеевич"));
            add(new Employee("Макс", "Хмыров", "Антонович"));
            add(new Employee("Андрей", "Хлебный", "Андреевич"));
        }};

        List<String> texts = new ArrayList<String>(){{
           add("Купить хлеб");
           add("Помыть машину");
           add("Выкинуть мусор");
           add("Купить телефон");
           add("Продать квартиру");
           add("Купить клей");
           add("Помыть окна");
           add("Покормить голубя");
           add("Вернуть телефон");
           add("Сломать ногу");
        }};

        List<Document> documents = new ArrayList<>();

        DocumentFactory documentFactory = new DocumentFactory(texts, employees);


        documents.add(documentFactory.createDocument(DocumentType.TASK));
        documents.add(documentFactory.createDocument(DocumentType.TASK));
        documents.add(documentFactory.createDocument(DocumentType.INCOMING));
        documents.add(documentFactory.createDocument(DocumentType.OUTGOING));
        documents.add(documentFactory.createDocument(DocumentType.TASK));
        documents.add(documentFactory.createDocument(DocumentType.INCOMING));
        documents.add(documentFactory.createDocument(DocumentType.INCOMING));
        documents.add(documentFactory.createDocument(DocumentType.OUTGOING));



        Map<Employee, List<Document>> map = documents.stream()
                .collect(Collectors.groupingBy(Document::getAuthor));

        for(Map.Entry<Employee, List<Document>> item : map.entrySet()){
            System.out.println(item.getKey().toString() + ":");
            for(Document document : item.getValue()){
                System.out.println("\t" + document.toString());
            }
            System.out.println();
        }

    }
}
