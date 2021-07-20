package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Incoming extends Document {

    private Employee sender;
    private Employee recipient;
    private String outgoingNumber;
    private Date outgoingRegistrationDate;

    public Incoming(int id, String name, String text, Date registrationDate, Employee author, Employee sender, Employee recipient,
                    String outgoingNumber, Date outgoingRegistrationDate){
        super(id, name, text, registrationDate, author);
        this.sender = sender;
        this.recipient = recipient;
        this.outgoingNumber = outgoingNumber;
        this.outgoingRegistrationDate = outgoingRegistrationDate;
    }

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public Employee getRecipient() {
        return recipient;
    }

    public void setRecipient(Employee recipient) {
        this.recipient = recipient;
    }

    public String getOutgoingNumber() {
        return outgoingNumber;
    }

    public void setOutgoingNumber(String outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public Date getOutgoingRegistrationDate() {
        return outgoingRegistrationDate;
    }

    public void setOutgoingRegistrationDate(Date outgoingRegistrationDate) {
        this.outgoingRegistrationDate = outgoingRegistrationDate;
    }


    @Override
    public String toString() {
        return "Incoming{" +
                super.toString() +
                "sender=" + sender +
                ", recipient=" + recipient +
                ", outgoingNumber='" + outgoingNumber + '\'' +
                ", outgoingRegistrationDate=" + outgoingRegistrationDate +
                '}';
    }

    @Override
    public String printDocument() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Входящий №" + getRegistrationNumber() + " от " + format.format(getRegistrationDate()) + ". " + getName();
    }
}
