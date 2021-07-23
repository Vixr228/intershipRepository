package Utils.ParsePackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organizationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationList {

    @XmlElement(name = "organization", type = AdaptedOrganization.class)
    private List<AdaptedOrganization> organizationList = null;

    public List<AdaptedOrganization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<AdaptedOrganization> organizationList) {
        this.organizationList = organizationList;
    }
}
