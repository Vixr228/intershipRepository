package Entities;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "department")
public class Department extends Staff implements Serializable {
    private String fullName;
    private String shortName;
    private Person director;
    private List<String> contactNumbers;



    public Department(){}
    public Department(String fullName, String shortName, Person director, List<String> contactNumbers){
        this.fullName = fullName;
        this.shortName = shortName;
        this.director = director;
        this.contactNumbers = contactNumbers;
    }

    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    @XmlElement(name = "shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Person getDirector() {
        return director;
    }

    @XmlElement(name = "director")
    public void setDirector(Person director) {
        this.director = director;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    @XmlElement(name = "contactNumbers")
    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", director=" + director +
                ", contactNumbers=" + contactNumbers +
                '}';
    }
}
