package utils.parseutils;

import utils.parseutils.adapters.DepartmentAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Класс DepartmentList используется для парсинга массива данных Department из XML источника.
 */

@XmlRootElement(name = "departmentList")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentList {

    @XmlElement(name = "department", type = DepartmentAdapter.AdaptedDepartment.class)
    private List<DepartmentAdapter.AdaptedDepartment> departmentList = null;

    public List<DepartmentAdapter.AdaptedDepartment> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<DepartmentAdapter.AdaptedDepartment> departmentList) {
        this.departmentList = departmentList;
    }


}