package ParsePackage;

import Entities.Department;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "departmentList")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentList {

    @XmlElement(name = "department", type = Department.class)
    private List<Department> departmentList = null;

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }


}