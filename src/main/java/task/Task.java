/**
 * The {@code Task} class represents a generic task with a description
 * and a completion status. It provides methods to retrieve and modify
 * the task's state.
 */
package task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {//task constructor, defaults to NOT DONE upon creation
        this.description = description;
        this.isDone = false;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}