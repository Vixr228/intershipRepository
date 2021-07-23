package Utils.ParsePackage;

import Entities.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organization")
public class AdaptedOrganization {
    private String fullName;
    private String shortName;
    private Person director;
    private PhoneNumbersList contactList;

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

}
