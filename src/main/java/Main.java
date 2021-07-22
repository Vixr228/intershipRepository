import Entities.*;
import ParsePackage.DepartmentList;
import ParsePackage.OrganizationList;
import ParsePackage.PersonList;
import Utils.DocumentExistException;
import Utils.DocumentFactory;
import Utils.XMLParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) throws DocumentExistException, JAXBException {


        XMLParser xmlParser = new XMLParser();
        PersonList personList = xmlParser.parsePerson("src/main/resources/PersonList.xml");

        personList.getPersonList().forEach(System.out::println);

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
        DocumentFactory documentFactory = new DocumentFactory(texts, personList.getPersonList(), deliveryMethods);
        //Лист с классами для того, чтобы выбирать случайный класс и подставлять его во входные параметры
        List<Class<? extends Document>> classes = new ArrayList<Class<? extends Document>>(){{
            add(Task.class);
            add(Incoming.class);
            add(Outgoing.class);
        }};
        for(int i = 0; i < 5; i++){
            int index = (int) (Math.random() * 3);
            documents.add(documentFactory.createDocument(classes.get(index)));
        }

        //Группируем документы по авторам и выводим
        Map<Person, List<Document>> map = documents.stream().sorted(Comparator.comparing(o -> o.getAuthor().getSurname()))
                .collect(Collectors.groupingBy(Document::getAuthor));
        TreeMap<Person, List<Document>> sorted = new TreeMap<>(map);


        for(Map.Entry<Person, List<Document>> item : sorted.entrySet()){
            System.out.println(item.getKey().getFullName() + ":");
            for(Document document : item.getValue()){
                System.out.println("\t" + document.printDocument());
            }
            System.out.println();
        }


//        DepartmentList departmentList = xmlParser.parseDepartment("src/main/resources/DepartmentList.xml");
//        departmentList.getDepartmentList().forEach(System.out::println);
        DepartmentList department = xmlParser.parseDepartment("src/main/resources/DepartmentList.xml");
        department.getDepartmentList().forEach(System.out::println);
//        Department d = department.getDepartmentList().get(0);
//        System.out.println(d.getContactList());

        OrganizationList organizationList = xmlParser.parseOrganization("src/main/resources/OrganizationList.xml");
        organizationList.getOrganizationList().forEach(System.out::println);
    }
}
