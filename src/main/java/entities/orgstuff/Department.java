package entities.orgstuff;

import utils.parse_utils.PhoneNumbersList;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Department extends Staff{

    private String fullName;
    private String shortName;
    private Person director;
    private PhoneNumbersList contactList;

    public Department(){}
    public Department(String fullName, String shortName, Person director, PhoneNumbersList contactList){
        super();
        this.fullName = fullName;
        this.shortName = shortName;
        this.director = director;
        this.contactList = contactList;

    }


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

    public PhoneNumbersList getContactList(){
        //return contactList.getNumberList();
        return contactList;
    }

    public void setContactList(PhoneNumbersList numbersList){
        this.contactList = numbersList;
    }


    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Department{");
        str.append("fullName=" + fullName);
        str.append(", shortName=" + shortName);
        str.append(", director=" + director);
        str.append(", contactNumbers=" + contactList.getNumberList());
        str.append('}');
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(fullName, that.fullName) && Objects.equals(shortName, that.shortName) && Objects.equals(director, that.director) && Objects.equals(contactList, that.contactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), fullName, shortName, director, contactList);
    }
}
