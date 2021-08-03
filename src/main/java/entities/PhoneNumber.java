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

    private static final String PHONE_VALIDATION_REGEX = "^(\\+7|8|7)[\\s\\-]?\\(?[0-9]{3}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}";
    private static final String CORRECT_PHONE_PATTERN = "+7(___)___-__-__";
    private String number;

    public PhoneNumber(){}

    public PhoneNumber(String number) {
        if (number.matches(PHONE_VALIDATION_REGEX)) {
            this.number = number;
        }
        else throw new IllegalArgumentException("Неправильный номер. Пример правильного номера: " + CORRECT_PHONE_PATTERN);
    }

    public String getNumber() {
        return number;
    }

    @XmlElement(name = "number")
    public void setNumber(String number) {
        if (number.matches(PHONE_VALIDATION_REGEX)) {
            this.number = number;
        }
        else throw new IllegalArgumentException("Неправильный номер. Пример правильного номера: " + CORRECT_PHONE_PATTERN);
    }

    public StringBuffer print() {
        StringBuffer str = new StringBuffer();
         str.append("PhoneNumber{" +
                "number='" + number + '\'' +
                '}');
         return str;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("PhoneNumber{");
        sb.append("number=" + number);
        sb.append('}');

        return sb.toString();
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
