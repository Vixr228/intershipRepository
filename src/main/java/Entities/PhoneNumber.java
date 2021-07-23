package Entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
