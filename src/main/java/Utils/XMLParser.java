package Utils;

import ParsePackage.DepartmentList;
import ParsePackage.OrganizationList;
import ParsePackage.PersonList;

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


    public DepartmentList parseDepartment(String path) throws JAXBException {
            JAXBContext context = JAXBContext.newInstance(DepartmentList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

             DepartmentList departmentList = (DepartmentList) unmarshaller.unmarshal(new File(path));

            return departmentList;
    }

    public OrganizationList parseOrganization(String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OrganizationList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        OrganizationList organizationList = (OrganizationList) unmarshaller.unmarshal(new File(path));


        return organizationList;
    }


    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
