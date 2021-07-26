package Utils.ParsePackage;

import Entities.OrgStuff.Person;
import Utils.ParsePackage.Adapters.DepartmentAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Класс AdapterDepartment - заменяет сущность Department при парсинге в XML. Для того, чтобы не нагружать модель сущности Department.
 */
@XmlRootElement(name = "department")
@XmlJavaTypeAdapter(DepartmentAdapter.class)
public class AdaptedDepartment {
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
        return contactList;
    }

    @XmlElement(name = "phoneNumberList")
    public void setContactList(PhoneNumbersList numbersList){
        this.contactList = numbersList;
    }
}
