package utils.parseutils;

import entities.PhoneNumber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

/**
 * Класс PhoneNumbersList используется для парсинга массива данных PhoneNumber из XML источника.
 */


@XmlRootElement(name = "phoneNumberList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumbersList {

    @XmlElement(name = "phoneNumber", type = PhoneNumber.class)
    private List<PhoneNumber> numberList = null;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumbersList that = (PhoneNumbersList) o;
        return Objects.equals(numberList, that.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    public PhoneNumbersList(){}

    public PhoneNumbersList(List<PhoneNumber> list){
        this.numberList = list;
    }

    public List<PhoneNumber> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<PhoneNumber> numberList) {
        this.numberList = numberList;
    }
}
