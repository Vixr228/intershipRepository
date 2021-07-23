package Entities;

import ParsePackage.PhoneNumbersList;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "department")
public class Department extends Staff implements Serializable{
    private String fullName;
    private String shortName;
    private Person director;
    private PhoneNumbersList contactList;



    public Department(){}
    public Department(String fullName, String shortName, Person director){
        this.fullName = fullName;
        this.shortName = shortName;
        this.director = director;

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

    @XmlElement(name = "person")
    public void setDirector(Person director) {
        this.director = director;
    }

    public PhoneNumbersList getContactList(){
        //return contactList.getNumberList();
        return contactList;
    }

    @XmlElement(name = "phoneNumberList")
    public void setContactList(PhoneNumbersList numbersList){
        this.contactList = numbersList;
    }


    @Override
    public String toString() {
        return "Department{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", director=" + director +
                ", contactList= " + getContactList().getNumberList() +
                '}';
    }
}
