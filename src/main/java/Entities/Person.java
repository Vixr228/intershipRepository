package Entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable<Person>{
    private String name;
    private String surname;
    private String patronymic;


    public Person(){}
    public Person(String name, String surname, String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
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

    public String getFullName(){
        return name + " " + surname + " " + patronymic;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic;
    }

    @Override
    public int compareTo(Person o) {
        return surname.compareTo(o.surname);
    }
}
