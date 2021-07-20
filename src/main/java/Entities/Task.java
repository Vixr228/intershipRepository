package Entities;

import Entities.Document;
import Entities.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task extends Document {
    private Date taskDate;
    private Date taskDeadline;
    private Employee taskExecutor;
    private String controlSign;
    private Employee taskController;

    Task(){}
    public Task(int id, String name, String text, Date registrationDate, Employee author, Date taskDate, Date taskDeadline,
                Employee taskExecutor, String controlSign, Employee taskController){
        super(id, name, text, registrationDate, author);
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
        return  "Task{" +
                super.toString() +
                "taskDate=" + taskDate +
                ", taskDeadline=" + taskDeadline +
                ", taskExecutor=" + taskExecutor +
                ", controlSign='" + controlSign + '\'' +
                ", taskController=" + taskController +
                '}';
    }

    @Override
    public String printDocument() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Поручение №" + getRegistrationNumber() + " от " + format.format(getRegistrationDate()) + ". " + getName();
    }
}
