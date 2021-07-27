package utils;

import entities.PhoneNumber;
import entities.documents.Document;
import entities.documents.Incoming;
import entities.documents.Outgoing;
import entities.documents.Task;
import entities.orgstuff.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.junit.Assert;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DocumentFactoryTest {
    DocumentFactory documentFactory;
    /**
     * Списки с данными для создания документа
     */
    List<String> texts = new ArrayList<String>(){{
        add("Купить хлеб");
    }};
    List<String> deliveryMethods = new ArrayList<String>(){{
        add("Самолет");
    }};
    List<Person> people = new ArrayList<Person>(){{
        add(new Person("Антон", "Антонов", "Антонович", "Работяга", new Date(1994, 8, 31), new PhoneNumber("89135489634")));
    }};

    @BeforeEach
    void setUp() {
        documentFactory = new DocumentFactory(texts, people, deliveryMethods);
    }
    /**
     * Создает несколько документов и проверяет, что у них разные id и registrationNumber, так же проверяет на правильность классов.
     */
    @Test()
    void createDocumentShouldReturnTrue() {
        Document firstTask = documentFactory.createDocument(Task.class);
        Document secondTask = documentFactory.createDocument(Task.class);
        Document incoming = documentFactory.createDocument(Incoming.class);
        Document outgoing = documentFactory.createDocument(Outgoing.class);
        assertNotEquals(firstTask.getId(), secondTask.getId());
        assertNotEquals(firstTask.getRegistrationNumber(), secondTask.getRegistrationNumber());
        assertEquals(firstTask.getClass(), Task.class);
        assertEquals(secondTask.getClass(), Task.class);
        assertNotEquals(incoming.getClass(), outgoing.getClass());
    }

}