import Entities.Document;
import Entities.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");



        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("Сергей", "Сергеев", "Сергеевич"));
            add(new Employee("Петр", "Петров", "Петрович"));
            add(new Employee("Антон", "Антонов", "Антонович"));
            add(new Employee("Макс", "Максивов", "Максимович"));
            add(new Employee("Андрей", "Андреев", "Андреевич"));
        }};

        List<String> texts = new ArrayList<String>(){{
           add("Купить хлеб");
           add("Помыть машину");
           add("Выкинуть мусор");
           add("Купить телефон");
           add("Продать квартиру");
        }};

        List<Date> dates = new ArrayList<Date>(){{
           add(new Date(21, 10, 12));
           add(new Date(19, 11, 24));
           add(new Date(20, 8, 1));
           add(new Date(21, 4, 13));
           add(new Date(20, 3, 29));
        }};

        List<String> names = new ArrayList<String>(){{
            add("Задача 1");
            add("Задача 2");
            add("Задача 3");
            add("Задача 4");
            add("Задача 5");
        }};

        List<Document> documents = new ArrayList<>();

        DocumentFactory documentFactory = new DocumentFactory(texts, employees, dates, names);

        documents.add(documentFactory.createDocument(DocumentType.TASK));
        documents.add(documentFactory.createDocument(DocumentType.TASK));
        documents.add(documentFactory.createDocument(DocumentType.INCOMING));
        documents.add(documentFactory.createDocument(DocumentType.OUTGOING));

       documents.forEach(doc -> System.out.println(doc.toString()));

    }
}
