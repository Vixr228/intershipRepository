package Entities;

import Entities.Document;
import Entities.Employee;

import java.util.Date;

public class Outgoing extends Document {

    private Employee recipient;
    private String deliveryMethod;

    public Outgoing(String name, String text, Date registrationDate, Employee author, Employee recipient, String deliveryMethod){
        this.setName(name);
        this.setText(text);
        this.setRegistrationDate(registrationDate);
        this.setAuthor(author);
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
        return "Исходящий №" + getRegistrationNumber() + " от " + getRegistrationDate() + ". " + getName();
    }
}
