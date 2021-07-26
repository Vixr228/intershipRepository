package Utils.ParsePackage.Adapters;

import Entities.OrgStuff.Department;
import Utils.ParsePackage.AdaptedDepartment;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * DepartmentAdapter нужен для преобразования AdaptedDepartment в Department.
 */
public class DepartmentAdapter extends XmlAdapter<AdaptedDepartment, Department> {
    /**
     * При операции unmarshall AdaptedDepartment передается в эту функцию и вызывается конструктор Department на основне полей AdaptedDepartment
     * @param v - AdaptedDepartment
     * @return Department
     * @throws Exception
     */
    @Override
    public Department unmarshal(AdaptedDepartment v) throws Exception {
        return new Department(v.getFullName(), v.getShortName(), v.getDirector(), v.getContactList());
    }

    @Override
    public AdaptedDepartment marshal(Department v) throws Exception {
        return null;
    }
}
