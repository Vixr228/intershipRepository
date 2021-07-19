import java.util.Date;

public class Task extends Document{
    private Date taskDate;
    private Date taskDeadline;
    private Employee taskExecutor;
    private String controlSign;
    private Employee taskController;

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
        return "Поручение №" + getId() + " от " + getRegistrationDate() + ". " + getName();
    }
}
