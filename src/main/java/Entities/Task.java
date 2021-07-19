package Entities;

import Entities.Document;
import Entities.Employee;

import java.util.Date;

public class Task extends Document {
    private Date taskDate;
    private Date taskDeadline;
    private Employee taskExecutor;
    private String controlSign;
    private Employee taskController;

    Task(){}
    public Task(String name, String text, Date registrationDate, Employee author, Date taskDate, Date taskDeadline,
                Employee taskExecutor, String controlSign, Employee taskController){
        this.setName(name);
        this.setText(text);
        this.setRegistrationDate(registrationDate);
        this.setAuthor(author);
        this.taskDate = taskDate;
        this.taskDeadline = taskDeadline;
        this.taskExecutor = taskExecutor;
        this.controlSign = controlSign;
        this.taskController = taskController;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Date getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public Employee getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(Employee taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public String getControlSign() {
        return controlSign;
    }

    public void setControlSign(String controlSign) {
        this.controlSign = controlSign;
    }

    public Employee getTaskController() {
        return taskController;
    }

    public void setTaskController(Employee taskController) {
        this.taskController = taskController;
    }

    @Override
    public String toString() {
        return "Поручение №" + getRegistrationNumber() + " от " + getRegistrationDate() + ". " + getName();
    }
}
