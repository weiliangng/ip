/**
 * The {@code Deadline} class represents a task with a specific due date.
 * It extends the {@code Task} class and includes an additional attribute for the deadline.
 */
package task;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import static params.Constants.FORMATTER;

public class Deadline extends Task {
    protected LocalDateTime dueDate;

    public Deadline(String description, LocalDateTime dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate.format(FORMATTER);
    }

    public String getTimeUntilDeadline() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, dueDate);
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        return days + " days and " + hours + " hours remaining";
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (due by: " + getDueDate() + "), " + getTimeUntilDeadline();
    }
}
