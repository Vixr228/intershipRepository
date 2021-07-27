package utils;

import entities.orgstuff.Department;
import entities.orgstuff.Organization;
import entities.orgstuff.Person;
import utils.parseutils.adapters.DepartmentAdapter;
import utils.parseutils.adapters.OrganizationAdapter;
import utils.parseutils.adapters.PersonAdapter;
import utils.parseutils.DepartmentList;
import utils.parseutils.OrganizationList;
import utils.parseutils.PersonList;
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
        JAXBContext context = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PersonList personList = (PersonList) unmarshaller.unmarshal(new File(path));

        PersonAdapter personAdapter = new PersonAdapter(personList);

        List<Person> p = personAdapter.adaptedPersonsToPersons();
        return personAdapter.adaptedPersonsToPersons();
    }
    public List<Department> parseDepartments(String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DepartmentList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        DepartmentList departmentList = (DepartmentList) unmarshaller.unmarshal(new File(path));

        DepartmentAdapter departmentAdapter = new DepartmentAdapter(departmentList);
        return departmentAdapter.adaptedDepartmentsToDepartments();
    }

    public List<Organization> parseOrganizations(String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OrganizationList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OrganizationList organizationList = (OrganizationList) unmarshaller.unmarshal(new File(path));

        OrganizationAdapter organizationAdapter = new OrganizationAdapter(organizationList);

        return organizationAdapter.adaptedOrganizationsToOrganizations();
    }


    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
