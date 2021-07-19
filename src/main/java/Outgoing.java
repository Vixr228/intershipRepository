public class Outgoing extends Document{

    private Employee recipient;
    private String deliveryMethod;

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
        return "Исходящий №" + getId() + " от " + getRegistrationDate() + ". " + getName();
    }
}
