package utils.parseutils;

import utils.parseutils.adapters.OrganizationAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Класс OrganizationList используется для парсинга массива данных Organization из XML источника.
 */

@XmlRootElement(name = "organizationList")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationList {

    @XmlElement(name = "organization", type = OrganizationAdapter.AdaptedOrganization.class)
    private List<OrganizationAdapter.AdaptedOrganization> organizationList = null;

    public List<OrganizationAdapter.AdaptedOrganization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<OrganizationAdapter.AdaptedOrganization> organizationList) {
        this.organizationList = organizationList;
    }
}
