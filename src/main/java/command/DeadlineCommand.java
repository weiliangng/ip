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


    /**
     * Constructs a {@code DeadlineCommand} by parsing the provided arguments.
     *
     * @param args The input string containing the task description and deadline, separated by "-by".
     * @throws BlarneyException If the input format is incorrect.
     */
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


    /**
     * Executes the command by creating a new {@code Deadline} task and adding it to the task list.
     *
     * @param tasks The {@code TaskList} where the new deadline task will be added.
     * @throws BlarneyException If an error occurs while adding the task.
     */
    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        Task newTask = new Deadline(description, by);
        tasks.addTask(newTask);
        System.out.println(SOLIDLINE + "Added: " + newTask + "\n" + SOLIDLINE);
    }
}
