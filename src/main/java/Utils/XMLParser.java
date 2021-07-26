package Utils;

import Entities.OrgStuff.Department;
import Entities.OrgStuff.Organization;
import Entities.OrgStuff.Person;
import Utils.ParsePackage.Adapters.DepartmentAdapter;
import Utils.ParsePackage.Adapters.OrganizationAdapter;
import Utils.ParsePackage.Adapters.PersonAdapter;
import Utils.ParsePackage.DepartmentList;
import Utils.ParsePackage.OrganizationList;
import Utils.ParsePackage.PersonList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс XMLParser занимается парсингом данных из XML файлов при помощи библиотеки JAXB.
 * Есть три функции, parsePersons - для парсинга людей.
 * parseDepartments - парсинг департаментов.
 * parseOrganization - парсинг организаций.
 * На вход функциям подается путь до XML файла. На выходе получается ArrayList данных.
 */
public class XMLParser {
    public static Logger logger = LogManager.getRootLogger();
    public List<Person> parsePersons(String path) throws Exception {
        List<Person> persons = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PersonList personList = (PersonList) unmarshaller.unmarshal(new File(path));

        PersonAdapter personAdapter = new PersonAdapter();
        personList.getPersonList().forEach(p -> {
            try {
                persons.add(personAdapter.unmarshal(p));
            } catch (Exception e) {
                logger.error("При парсинге человека возникла ошибка.");
                e.printStackTrace();
            }
        });

        return persons;
    }
    public List<Department> parseDepartments(String path) throws JAXBException {
        List<Department> departments = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(DepartmentList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        DepartmentList departmentList = (DepartmentList) unmarshaller.unmarshal(new File(path));

        DepartmentAdapter departmentAdapter = new DepartmentAdapter();
        departmentList.getDepartmentList().forEach(d -> {
            try {
                departments.add(departmentAdapter.unmarshal(d));
            } catch (Exception e) {
                logger.error("При парсинге департамента возникла ошибка.");
                e.printStackTrace();
            }
        });

        return departments;
    }

    public List<Organization> parseOrganizations(String path) throws JAXBException {
        List<Organization> organizations = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(OrganizationList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OrganizationList organizationList = (OrganizationList) unmarshaller.unmarshal(new File(path));

        OrganizationAdapter organizationAdapter = new OrganizationAdapter();
        organizationList.getOrganizationList().forEach(o -> {
            try {
                organizations.add(organizationAdapter.unmarshal(o));
            } catch (Exception e) {
                logger.error("При парсинге организации возникла ошибка.");
                e.printStackTrace();
            }
        });

        return organizations;
    }


    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
