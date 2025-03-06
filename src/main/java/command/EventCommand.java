
package command;

import exception.BlarneyException;
import task.Task;
import task.TaskList;
import task.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static params.Constants.FORMATTER;
import static params.Constants.SOLIDLINE;

public class EventCommand extends Command {
    private final String description;
    private final String begin;
    private final String end;
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;

    public EventCommand(String args) {
        super(args);
        String[] parts = args.split(" -from | -to ");

        if (parts.length == 3) {
            this.description = parts[0].trim();
            this.begin = parts[1].trim();
            this.end = parts[2].trim();

        } else {
            throw new BlarneyException("Invalid input format, your arguments are invalid");
        }
        try {
            this.startDate = LocalDateTime.parse(begin, FORMATTER);
            this.endDate = LocalDateTime.parse(end, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new BlarneyException("Invalid date-time format. Please use dd-MM-yyyy HH:mm");
        }
    }

    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        Task newTask = new Event(description, startDate, endDate);
        tasks.addTask(newTask);
        System.out.println(SOLIDLINE + "Added: " + newTask + "\n" + SOLIDLINE);
    }
}
