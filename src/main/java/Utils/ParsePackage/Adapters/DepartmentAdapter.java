package Utils.ParsePackage.Adapters;

import Entities.Department;
import Utils.ParsePackage.AdaptedDepartment;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DepartmentAdapter extends XmlAdapter<AdaptedDepartment, Department> {
    @Override
    public Department unmarshal(AdaptedDepartment v) throws Exception {
        return new Department(v.getFullName(), v.getShortName(), v.getDirector(), v.getContactList());
    }

    @Override
    public AdaptedDepartment marshal(Department v) throws Exception {
        return null;
    }
}
