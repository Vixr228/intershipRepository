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

    public PhoneNumber(String number) {
        if (number.matches("^(\\+7|8|7)[\\s\\-]?\\(?[0-9]{3}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}")) {
            this.number = number;
        }
        else throw new IllegalArgumentException("Wrong number");
    }

    public String getNumber() {
        return number;
    }

    @XmlElement(name = "number")
    public void setNumber(String number) {
        if (number.matches("^(\\+7|8|7)[\\s\\-]?\\(?[0-9]{3}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}")) {
            this.number = number;
        }
        else throw new IllegalArgumentException("Wrong number");
    }

    public StringBuffer print() {
        StringBuffer str = new StringBuffer();
         str.append("PhoneNumber{" +
                "number='" + number + '\'' +
                '}');
         return str;
    }

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

}
