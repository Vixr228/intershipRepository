package Utils.ParsePackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "departmentList")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentList {

    @XmlElement(name = "department", type = AdaptedDepartment.class)
    private List<AdaptedDepartment> departmentList = null;

    public List<AdaptedDepartment> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<AdaptedDepartment> departmentList) {
        this.departmentList = departmentList;
    }


}