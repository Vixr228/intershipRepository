import java.util.Date;

public class Incoming extends Document{

    private Employee sender;
    private Employee recipient;
    private String outgoingNumber;
    private Date outgoingRegistrationDate;

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
        return "Входящий №" + getId() + " от " + getRegistrationDate() + ". " + getName();
    }
}
