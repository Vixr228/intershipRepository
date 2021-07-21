package Entities;

public class Employee implements Comparable<Employee>{
    private String name;
    private String surname;
    private String patronymic;


    public Employee(String name, String surname, String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName(){
        return name + " " + surname + " " + patronymic;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic;
    }

    @Override
    public int compareTo(Employee o) {
        return surname.compareTo(o.surname);
    }
}
