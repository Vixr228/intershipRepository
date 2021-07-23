package Entities;

import Entities.Document;
import Entities.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Outgoing extends Document {

    private Employee recipient;
    private String deliveryMethod;

    public Outgoing(UUID id, String name, String text, Date registrationDate, Employee author, Employee recipient, String deliveryMethod){
        super(id, name, text, registrationDate, author);
        this.recipient = recipient;
        this.deliveryMethod = deliveryMethod;
    }

    public Employee getRecipient() {
        return recipient;
    }

    public void setRecipient(Employee recipient) {
        this.recipient = recipient;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }


    @Override
    public String toString() {
        return "Outgoing{" +
                super.toString() +
                "recipient=" + recipient +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                '}';
    }

    @Override
    public String printDocument() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Исходящий №" + getRegistrationNumber() + " от " + format.format(getRegistrationDate()) + ". " + getName();
    }
}
