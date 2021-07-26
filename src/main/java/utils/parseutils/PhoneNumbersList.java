package utils.parseutils;

import entities.PhoneNumber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Класс PhoneNumbersList используется для парсинга массива данных PhoneNumber из XML источника.
 */


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
