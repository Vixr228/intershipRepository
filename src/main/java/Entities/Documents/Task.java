package Entities.Documents;

import Entities.OrgStuff.Person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Task extends Document {
    private Date taskDate;
    private Date taskDeadline;
    private Person taskExecutor;
    private String controlSign;
    private Person taskController;

    Task(){}
    public Task(UUID id, String name, String text, Date registrationDate, Person author, Date taskDate, Date taskDeadline,
                Person taskExecutor, String controlSign, Person taskController){
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

    public Person getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(Person taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public String getControlSign() {
        return controlSign;
    }

    public void setControlSign(String controlSign) {
        this.controlSign = controlSign;
    }

    public Person getTaskController() {
        return taskController;
    }

    public void setTaskController(Person taskController) {
        this.taskController = taskController;
    }

    public StringBuffer print() {
        StringBuffer str = new StringBuffer();
        str.append("Task{" +
                super.toString() +
                "taskDate=" + taskDate +
                ", taskDeadline=" + taskDeadline +
                ", taskExecutor=" + taskExecutor +
                ", controlSign='" + controlSign + '\'' +
                ", taskController=" + taskController +
                '}');
        return str;
    }

    @Override
    public String printDocument() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return "Поручение №" + getRegistrationNumber() + " от " + format.format(getRegistrationDate()) + ". Дедлайн: " + format.format(getTaskDeadline()) + ". " + getName();
    }
}
