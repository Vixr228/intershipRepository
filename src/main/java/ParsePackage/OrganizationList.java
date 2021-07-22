package ParsePackage;

import Entities.Department;
import Entities.Organization;
import Entities.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organizationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationList {

    @XmlElement(name = "organization", type = Organization.class)
    private List<Organization> organizationList = null;

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }
}
