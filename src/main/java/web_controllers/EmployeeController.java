package web_controllers;

import entities.documents.Document;
import entities.orgstuff.Person;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import repositories.PersonRepository;
import utils.XMLParser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;


@Path("/ecm")
public class EmployeeController {
    //public static Logger logger = LogManager.getRootLogger();
    Logger log = Logger.getLogger(getClass().getName());
    public static final String EMPLOYEE_NOT_FOUND_ERROR = "Employee not found.";
    public static final String DOCUMENT_NOT_FOUND_ERROR = "Documents not found";
    //PersonRepository personRepository = new PersonRepository();


    @GET()
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeList(){
        List<Person> personList = Application.personRepository.getPersonList();
        if(personList.size() == 0 || personList == null) {
            log.severe("getEmployeeList - Проблема при парсинге работников из XML файла");
            return Response.status(Response.Status.NOT_FOUND).entity(EMPLOYEE_NOT_FOUND_ERROR).build();
        }
        return Response.status(Response.Status.OK).entity(personList).build();
    }


    @GET
    @Path("/employees/{id}")
    public Response getEmployeeById(@PathParam("id") UUID id) throws IOException {
        Person person = Application.personRepository.getPersonById(id);
        List<Document> documentList = Application.personRepository.getDocumentReportById(id);
        if(documentList == null){
            log.severe("NLL DOCUMENT");
            return Response.status(Response.Status.NOT_FOUND).entity(DOCUMENT_NOT_FOUND_ERROR).encoding("UTF-8").build();
        }
        FileWriter file = Application.personRepository.documentToXmlFile(documentList);

        log.severe("NOT NULL DOCUMENT");
        GenericEntity<FileWriter> entity = new GenericEntity<FileWriter>(file) {};
        return Response.status(Response.Status.OK).entity(entity).build();
    }
}
