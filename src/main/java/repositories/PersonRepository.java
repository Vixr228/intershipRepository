package repositories;

import entities.PhoneNumber;
import entities.documents.Document;
import entities.documents.Task;
import entities.orgstuff.Person;
import utils.XMLParser;
import web_controllers.Application;

import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public List<Document> getDocumentReportById(UUID id){
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

    public FileWriter documentToXmlFile(List<Document> documentList) throws IOException {
        FileWriter file = new FileWriter("/Users/user/Desktop/intershiprepository/src/main/resources/file.xml");
        StringBuffer str = new StringBuffer("");
        file.write("<documentList>\n");
        for(Document document : documentList){
            str.append("\t<document>\n");
            str.append(document.convertDocumentToXml());
            str.append("\t</document>\n");
            file.write(String.valueOf(str));
        }
        file.write("</documentList>\n");
        file.close();

          return file;
    }
}