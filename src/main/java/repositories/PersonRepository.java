package repositories;

import entities.documents.Document;
import entities.orgstuff.Person;
import utils.XMLParser;
import web_controllers.Application;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Класс осуществляющий работу с Работниками
 */

public class PersonRepository {
    public static final String PERSONS_XML_PATH = "/Users/user/Desktop/intershiprepository/src/main/resources/xml/PersonList.xml";
    Logger log = Logger.getLogger(getClass().getName());
    XMLParser xmlParser;
    List<Person> personList;

    public PersonRepository() {
        xmlParser = new XMLParser();
        try {
            personList = xmlParser.parsePersons(PERSONS_XML_PATH);
        } catch (Exception e) {
            log.severe("getEmployeeList - Проблема при парсинге работников из XML файла");
            e.printStackTrace();
        }
    }

    /**
     * Возвращает список всех работникок
     * @return List<Person>
     */
    public List<Person> getPersonList() {
        return personList;
    }

    public Person getPersonById(UUID id) {
        Person person = null;
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                person = p;
                break;
            }
        }
        return person;
    }

    /**
     * Возвращает списко документов, автором которых является работником с конкретным id
     * @param id - сотрудник, список документов которого нам нужен
     * @return List<Document> - список документов сотрудника
     */
    public List<Document> getDocumentReportByAuthorId(UUID id){
        List<Document> documentReport = null;
        Map<Person, List<Document>> map = Application.documents.stream().collect(Collectors.groupingBy(Document::getAuthor));
        Person person = getPersonById(id);
        if(person != null){
            if(map.containsKey(person)){
                documentReport = map.get(person);
                return documentReport;
            }
        }
        return documentReport;

    }

    /**
     * Возвращает список документов в XML формате
     * @param documentList - список документов
     * @return StringBuffer - строка в XML формате
     */
    public StringBuffer documentToXmlFile(List<Document> documentList){
        StringBuffer str = new StringBuffer("");
              str.append("<documentList>\n");
        for(Document document : documentList){
            str.append("\t<document>\n");
            str.append(document.convertDocumentToXml());
            str.append("\t</document>\n");
        }
        str.append("</documentList>\n");

          return str;
    }
}