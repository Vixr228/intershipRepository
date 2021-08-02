package web_controllers;

import entities.documents.Document;
import entities.orgstuff.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.logging.Logger;

/**
 * Класс который осуществляет доступ на веб страницы по путям
 */

@Path("/ecm")
public class EmployeeController {
    Logger log = Logger.getLogger(getClass().getName());
    public static final String EMPLOYEE_NOT_FOUND_ERROR = "Employee not found.";
    public static final String DOCUMENT_NOT_FOUND_ERROR = "Documents not found";

    /**
     * GET запрос по адресу /employee.
     * @return Возвращает список всех работников в JSON формате.
     */
    @GET()
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeList(){
        List<Person> personList = Application.personRepository.getPersonList();
        if(personList.size() == 0) {
            log.severe("getEmployeeList - Проблема при парсинге работников из XML файла");
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity(EMPLOYEE_NOT_FOUND_ERROR).encoding("UTF-8").build();
        }
        return Response.status(Response.Status.OK).entity(personList).encoding("UTF-8").build();
    }


    /**
     * GET запрос по адресу /employee/{id}.
     * @return Возвращает список документов, автором которых является работник с данным id в формате XML.
     */
    @GET
    @Path("/employees/{id}")
    @Produces(MediaType.TEXT_XML)
    public Response getEmployeeReportById(@PathParam("id") UUID id){
        List<Document> documentList = Application.personRepository.getDocumentReportById(id);
        if(documentList == null){
            log.severe("getEmployeeReportById - не найдены документы у работника с id: " + id);
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity(DOCUMENT_NOT_FOUND_ERROR).encoding("UTF-8").build();
        }
        StringBuffer str = Application.personRepository.documentToXmlFile(documentList);
        return Response.status(Response.Status.OK).entity(str.toString()).encoding("UTF-8").build();
    }
}
