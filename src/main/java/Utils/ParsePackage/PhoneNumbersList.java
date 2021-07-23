package Utils.ParsePackage;

import Entities.PhoneNumber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "phoneNumberList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumbersList {

    @XmlElement(name = "phoneNumber", type = PhoneNumber.class)
    private List<PhoneNumber> numberList = null;

    public List<PhoneNumber> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<PhoneNumber> numberList) {
        this.numberList = numberList;
    }
}
