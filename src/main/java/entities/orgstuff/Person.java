package entities.orgstuff;

import entities.PhoneNumber;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Person extends Staff implements Comparable<Person>, Serializable {


    private transient UUID id;
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private Date birthDate;
    private PhoneNumber phoneNumber;



    public Person(){}
    public Person(String name, String surname, String patronymic, String position, Date birthDate, PhoneNumber phoneNumber){
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
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
    public String getFullName(){
        return name + " " + surname + " " + patronymic;
    }

    public StringBuffer print() {
        StringBuffer str = new StringBuffer();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        str.append("Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position='" + position + '\'' +
                ", birthDate=" + format.format(getBirthDate()) +
                ", phoneNumber=" + phoneNumber +
                '}');
        return str;
    }

    @Override
    public int compareTo(Person o) {
        return surname.compareTo(o.surname);
    }
}
