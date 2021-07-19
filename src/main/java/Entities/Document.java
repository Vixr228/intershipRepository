package Entities;

import java.util.Date;

public abstract class Document implements Comparable<Document>{

    private int id;
    private String name;
    private String text;
    private int registrationNumber;
    private Date registrationDate;
    private Employee author;

    public Document(){
        this.id = (int) Math.random() * 1000;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    @Override
    public int compareTo(Document secondDoc) {
        if(id - secondDoc.id != 0) return id - secondDoc.id;
        return registrationDate.compareTo(secondDoc.registrationDate);
    }

}
