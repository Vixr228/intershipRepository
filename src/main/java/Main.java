import Entities.Document;
import Entities.DocumentExistException;
import Entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DocumentExistException {
        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("Сергей", "Сергеев", "Сергеевич"));
            add(new Employee("Петр", "Петров", "Петрович"));
            add(new Employee("Антон", "Антонов", "Антонович"));
            add(new Employee("Макс", "Максивов", "Максимович"));
            add(new Employee("Андрей", "Андреев", "Андреевич"));
            add(new Employee("Сергей", "Антонов", "Петрович"));
            add(new Employee("Петр", "Максивом", "Андреевич"));
            add(new Employee("Антон", "Петров", "Сергеевич"));
            add(new Employee("Макс", "Сергеев", "Антонович"));
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

//        List<String> names = new ArrayList<String>(){{
//            add("Задача 1");
//            add("Задача 2");
//            add("Задача 3");
//            add("Задача 4");
//            add("Задача 5");
//            add("Задача 6");
//            add("Задача 7");
//            add("Задача 8");
//            add("Задача 9");
//            add("Задача 10");
//        }};

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



       documents.forEach(doc -> System.out.println(doc.toString()));



    }
}
