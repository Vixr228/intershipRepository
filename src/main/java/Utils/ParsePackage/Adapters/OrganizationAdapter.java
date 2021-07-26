package Utils.ParsePackage.Adapters;

import Entities.OrgStuff.Organization;
import Utils.ParsePackage.AdaptedOrganization;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * OrganizationAdapter нужен для преобразования AdaptedOrganization в Organization.
 */

public class OrganizationAdapter extends XmlAdapter<AdaptedOrganization, Organization> {
    /**
     * При операции unmarshall AdaptedOrganization передается в эту функцию и вызывается конструктор Organization на основне полей AdaptedOrganization
     * @param v - AdaptedOrganization
     * @return Organization
     * @throws Exception
     */
    @Override
    public Organization unmarshal(AdaptedOrganization v) throws Exception {
        return new Organization(v.getFullName(), v.getShortName(), v.getDirector(), v.getContactList());
    }

    @Override
    public AdaptedOrganization marshal(Organization v) throws Exception {
        return null;
    }
}
