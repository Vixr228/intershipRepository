package entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * Класс PhoneNumber - служит для сохранения поля номера телефона.
 */

@XmlRootElement(name = "phoneNumber")
public class PhoneNumber implements Serializable {
    private String number;

    public PhoneNumber(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public PhoneNumber(String number){
        this.number = number;
    }
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
