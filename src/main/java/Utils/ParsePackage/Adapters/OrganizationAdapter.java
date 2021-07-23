package Utils.ParsePackage.Adapters;

import Entities.Organization;
import Utils.ParsePackage.AdaptedOrganization;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OrganizationAdapter extends XmlAdapter<AdaptedOrganization, Organization> {
    @Override
    public Organization unmarshal(AdaptedOrganization v) throws Exception {
        return new Organization(v.getFullName(), v.getShortName(), v.getDirector(), v.getContactList());
    }

    @Override
    public AdaptedOrganization marshal(Organization v) throws Exception {
        return null;
    }
}
