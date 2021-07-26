package Entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Класс PhoneNumber - служит для сохранения поля номера телефона.
 */

@XmlRootElement(name = "phoneNumber")
public class PhoneNumber implements Serializable {
    private String number;

    public String getNumber() {
        return number;
    }

    @XmlElement(name = "number")
    public void setNumber(String number) {
        this.number = number;
    }

    public StringBuffer print() {
        StringBuffer str = new StringBuffer();
         str.append("PhoneNumber{" +
                "number='" + number + '\'' +
                '}');
         return str;
    }
}
