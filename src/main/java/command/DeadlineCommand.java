package command;

import exception.BlarneyException;
import task.Deadline;
import task.Task;
import task.TaskList;
import task.Event;

import static params.Constants.SOLIDLINE;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String args) {
        super(args);
        String[] parts = args.split(" -by ");

        if (parts.length == 2) {
            this.description = parts[0].trim();
            this.by = parts[1].trim();

        } else {
            throw new BlarneyException("Invalid input format, your arguments are invalid");
        }
    }

    @Override
    public void execute(TaskList tasks) throws BlarneyException {
        Task newTask = new Deadline(description, by);
        tasks.addTask(newTask);
        System.out.println(SOLIDLINE + "Added: " + newTask + "\n" + SOLIDLINE);
    }
}
