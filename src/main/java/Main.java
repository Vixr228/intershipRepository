import Entities.*;
import Utils.DocumentExistException;
import Utils.DocumentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) throws DocumentExistException {

        //Заранее подготовленные значения для заполнения документов
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

        List<String> deliveryMethods = new ArrayList<String>(){{
            add("Самолет");
            add("Поезд");
            add("Машина");
            add("Корабль");
        }};

        //Заполняем документы
        List<Document> documents = new ArrayList<>();
        DocumentFactory documentFactory = new DocumentFactory(texts, employees, deliveryMethods);
        //Лист с классами для того, чтобы выбирать случайный класс и подставлять его во входные параметры
        List<Class<?>> classes = new ArrayList<Class<?>>(){{
            add(Task.class);
            add(Incoming.class);
            add(Outgoing.class);
        }};
        for(int i = 0; i < 50; i++){
            int index = (int) (Math.random() * 3);
            documents.add(documentFactory.createDocument(classes.get(index)));
        }

        //Группируем документы по авторам и выводим
        Map<Employee, List<Document>> map = documents.stream()
                .collect(Collectors.groupingBy(Document::getAuthor));

        for(Map.Entry<Employee, List<Document>> item : map.entrySet()){
            System.out.println(item.getKey().toString() + ":");
            for(Document document : item.getValue()){
                System.out.println("\t" + document.printDocument());
            }
            System.out.println();
        }

    }
}
