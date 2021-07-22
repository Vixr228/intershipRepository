package ParsePackage;

import Entities.Person;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "personList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonList {

    @XmlElement(name = "person", type = Person.class)
    private List<Person> personList = null;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }


}
