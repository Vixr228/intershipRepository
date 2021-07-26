package Utils.ParsePackage;

import Entities.PhoneNumber;
import Utils.ParsePackage.Adapters.PersonAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Класс AdaptedPerson - заменяет сущность Person при парсинге в XML. Для того, чтобы не нагружать модель сущности Person.
 */

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(PersonAdapter.class)
public class AdaptedPerson {
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private Date birthDate;
    private PhoneNumber phoneNumber;

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
