/**
 * The {@code Command} class serves as an abstract base for all command types.
 * It provides a method for executing commands while handling exceptions.
 */

package command;

import task.TaskList;
import java.io.IOException;
import exception.BlarneyException;

public abstract class Command {
    public Command(String args) {}
    public Command() {}



    /**
     * Executes the command while handling potential exceptions.
     *
     * @param tasks The {@code TaskList} on which the command operates.
     * @return {@code true} if execution is successful, {@code false} if an exception occurs.
     */
    public boolean execute(TaskList tasks) {
        try {
            runCommand(tasks); // Call abstract method
            return true; // Return true if no exceptions occur
        } catch (BlarneyException | IOException e) {
            System.out.println("Error: " + e.getMessage()); // Print error message
            return false; // Return false if an exception is thrown
        }
    }

    /**
     * Executes the specific command logic, implemented in subclasses.
     *
     * @param tasks The {@code TaskList} to operate on.
     * @throws BlarneyException If an application-specific error occurs.
     * @throws IOException If an input/output error occurs.
     */
    protected abstract void runCommand(TaskList tasks) throws BlarneyException, IOException;
}
