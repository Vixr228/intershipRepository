package Entities;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlType(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department extends Staff {
    private String fullName;
    private String shortName;


    @XmlElement(name="director")
    private Person director;

//    @XmlElementWrapper(name="contactNumbers")
//    @XmlElement(name="contactNumbers")
    private List<String> contactNumbers;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

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
