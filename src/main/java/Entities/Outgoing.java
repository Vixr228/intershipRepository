package Entities;

import Entities.Document;
import Entities.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Outgoing extends Document {

    private Employee recipient;
    private String deliveryMethod;

    public Outgoing(String name, String text, Date registrationDate, Employee author, Employee recipient, String deliveryMethod){
        super(name, text, registrationDate, author);
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
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Исходящий №" + getRegistrationNumber() + " от " + format.format(getRegistrationDate()) + ". " + getName();
    }
}
