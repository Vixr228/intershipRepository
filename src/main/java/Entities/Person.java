package Entities;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "person")
public class Person implements Comparable<Person>, Serializable {
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private Date birthDate;
    private String phoneNumber;



    public Person(){}
    public Person(String name, String surname, String patronymic, String position, Date birthDate, String phoneNumber){
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
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    @XmlElement(name = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
    @XmlElement(name = "patronymic")
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    @XmlElement(name = "position")
    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    @XmlElement(name = "birthDate")
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @XmlElement(name = "phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getFullName(){
        return name + " " + surname + " " + patronymic;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position='" + position + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return surname.compareTo(o.surname);
    }
}
