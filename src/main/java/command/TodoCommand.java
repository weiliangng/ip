/**
 * The {@code TodoCommand} class handles the creation of a todo task.
 * It processes the user input to extract the task description and adds it to the task list.
 */

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


    /**
     * Executes the command by creating a new {@code Todo} task and adding it to the task list.
     *
     * @param tasks The {@code TaskList} where the new todo task will be added.
     * @throws BlarneyException If the task description is empty.
     */
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
