package Utils.ParsePackage;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "personList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonList {


    @XmlElement(name = "person", type = AdaptedPerson.class)
    private List<AdaptedPerson> personList = null;

    public List<AdaptedPerson> getPersonList() {
        return personList;
    }

    public void setPersonList(List<AdaptedPerson> personList) {
        this.personList = personList;
    }


}
