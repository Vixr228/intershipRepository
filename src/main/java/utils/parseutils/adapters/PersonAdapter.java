package utils.parseutils.adapters;

import entities.orgstuff.Person;
import entities.PhoneNumber;
import utils.parseutils.PersonList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * PersonAdapter нужен для преобразования AdaptedPerson в Person.
 */
public class PersonAdapter extends XmlAdapter<PersonAdapter.AdaptedPerson, Person> {

    /**
     * При операции unmarshall AdaptedPerson передается в эту функцию и вызывается конструктор Person на основне полей AdaptedPerson
     * @param v - AdaptedPerson
     * @return Person
     * @throws Exception
     */
    public static Logger logger = LogManager.getRootLogger();
    PersonList personList;

    public PersonAdapter(PersonList personList){
        this.personList = personList;

    }
    @Override
    public Person unmarshal(AdaptedPerson v) throws Exception {
        return new Person(v.getName(), v.getSurname(), v.getPatronymic(), v.getPosition(), v.getBirthDate(), v.getPhoneNumber());
    }

    @Override
    public AdaptedPerson marshal(Person v) throws Exception {
        return new AdaptedPerson(v.getName(), v.getSurname(), v.getPatronymic(), v.getPosition(), v.getBirthDate(), v.getPhoneNumber());
    }

    public List<Person> adaptedPersonsToPersons(){
        List<Person> persons = new ArrayList<>();
        personList.getPersonList().forEach(p -> {
            try {
                persons.add(unmarshal(p));
            } catch (Exception e) {
                logger.error("При парсинге человека возникла ошибка.");
                e.printStackTrace();
            }
        });
        return persons;
    }

    /**
     * Класс AdaptedPerson - заменяет сущность Person при парсинге в XML. Для того, чтобы не нагружать модель сущности Person.
     */

    @XmlRootElement(name = "person")
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlJavaTypeAdapter(PersonAdapter.class)
    public static class AdaptedPerson {
        private String name;
        private String surname;
        private String patronymic;
        private String position;
        private Date birthDate;
        private PhoneNumber phoneNumber;

        public AdaptedPerson(){}

        public AdaptedPerson(String name, String surname, String patronymic, String position, Date birthDate, PhoneNumber phoneNumber){
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.position = position;
            this.birthDate = birthDate;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public PhoneNumber getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

    }
}
