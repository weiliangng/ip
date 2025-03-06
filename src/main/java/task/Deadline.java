/**
 * The {@code Deadline} class represents a task with a specific due date.
 * It extends the {@code Task} class and includes an additional attribute for the deadline.
 */
package task;

public class Deadline extends Task {
    protected String dueDate;

    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (due by: " + dueDate + ")";
    }
}
