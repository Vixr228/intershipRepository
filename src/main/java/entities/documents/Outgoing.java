package entities.documents;

import entities.orgstuff.Person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Outgoing extends Document {

    private Person recipient;
    private String deliveryMethod;

    public Outgoing(UUID id, String name, String text, Date registrationDate, Person author, Person recipient, String deliveryMethod){
        super(id, name, text, registrationDate, author);
        this.recipient = recipient;
        this.deliveryMethod = deliveryMethod;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
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
        StringBuffer sb = new StringBuffer("Outgoing{" + super.toString());
        sb.append(", recipient=" + recipient );
        sb.append(", deliveryMethod=" + deliveryMethod);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String printDocument() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Исходящий №" + getRegistrationNumber() + " от " + format.format(getRegistrationDate()) + ". " + getName();
    }
}
