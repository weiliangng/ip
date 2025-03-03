package command;
import task.Task;
import task.TaskList;
import exception.BlarneyException;
import task.Todo;

import static params.Constants.SOLIDLINE;


public class TodoCommand extends Command{
    private final String taskDescription;

    public TodoCommand(String args) {
        super(args);
        this.taskDescription = args.trim();
    }

    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        if (taskDescription.isEmpty()) {
            throw new BlarneyException("Task description cannot be empty.");
        }

        Task newTask = new Todo(taskDescription);
        tasks.addTask(newTask);  // Calls the method to add a new task
        System.out.println(SOLIDLINE + "Added: " + newTask + "\n" + SOLIDLINE);

    }

}
