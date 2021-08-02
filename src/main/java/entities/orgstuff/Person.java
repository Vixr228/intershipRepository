package entities.orgstuff;

import entities.PhoneNumber;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@JsonbPropertyOrder({"name", "surname", "patronymic", "position", "birthDate", "phoneNumber"})
public class Person extends Staff implements Comparable<Person> {

    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private Date birthDate;
    private PhoneNumber phoneNumber;


    public Person(){}
    public Person(String name, String surname, String patronymic, String position, Date birthDate, PhoneNumber phoneNumber){
        super();
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
    public String getFullName(){
        return name + " " + surname + " " + patronymic;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        StringBuffer sb = new StringBuffer("Person{");
        sb.append("  name=" + name);
        sb.append(", surname=" + surname);
        sb.append(", patronymic=" + patronymic);
        sb.append(", position=" + position);
        sb.append(", birthDate=" + format.format(birthDate));
        sb.append(", phoneNumber=" + phoneNumber);
        sb.append('}');
        return sb.toString();
    }

    public StringBuffer toXML(){
        StringBuffer str = new StringBuffer();
        str.append("\t\t\t<id>" + getId() + "</id>\n");
        str.append("\t\t\t<name>" + getName() + "</name>\n");
        str.append("\t\t\t<surname>" + getSurname() + "</surname>\n");
        str.append("\t\t\t<patronymic>" + getPatronymic() + "</patronymic>\n");
        str.append("\t\t\t<position>" + getPosition() + "</position>\n");
        str.append("\t\t\t<birthDate>" + getBirthDate() + "</birthDate>\n");
        str.append("\t\t\t<phoneNumber>\n");
        str.append("\t\t\t\t<number>" + getPhoneNumber().getNumber() + "</number>\n");
        str.append("\t\t\t</phoneNumber>\n");

        return str;
    }

    @Override
    public int compareTo(Person o) {
        return surname.compareTo(o.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(patronymic, person.patronymic)
                && Objects.equals(position, person.position) && Objects.equals(birthDate, person.birthDate) && Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, surname, patronymic, position, birthDate, phoneNumber);
    }

}
