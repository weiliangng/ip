package command;

import exception.BlarneyException;
import task.Deadline;
import task.Task;
import task.TaskList;
import task.Event;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static params.Constants.FORMATTER;
import static params.Constants.SOLIDLINE;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;
    protected LocalDateTime dueDate;

    public DeadlineCommand(String args) {
        super(args);
        String[] parts = args.split(" -by ");

        if (parts.length == 2) {
            this.description = parts[0].trim();
            this.by = parts[1].trim();

        } else {
            throw new BlarneyException("Invalid input format, your arguments are invalid");
        }

        try {
            this.dueDate = LocalDateTime.parse(by, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new BlarneyException("Invalid date-time format. Please use dd-MM-yyyy HH:mm");
        }

    }

    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        Task newTask = new Deadline(description, dueDate);
        tasks.addTask(newTask);
        System.out.println(SOLIDLINE + "Added: " + newTask + "\n" + SOLIDLINE);
    }
}
