package Utils;

import Entities.Department;
import Entities.Person;
import Entities.PersonList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLParser {

    public PersonList parsePerson(String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        PersonList personList = (PersonList) unmarshaller.unmarshal(new File(path));

        return personList;
    }


    public Department parseDepartment(String path) throws JAXBException {
            JAXBContext context = JAXBContext.newInstance(Department.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

        Department Department = (Department) unmarshaller.unmarshal(new File(path));

            return Department;
        }


    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
