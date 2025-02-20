package command;

import task.TaskList;
import java.io.IOException;
import exception.BlarneyException;

public abstract class Command {
    public Command(String args) {}
    public Command() {}

    public boolean execute(TaskList tasks) {
        try {
            runCommand(tasks); // Call abstract method
            return true; // Return true if no exceptions occur
        } catch (BlarneyException | IOException e) {
            System.out.println("Error: " + e.getMessage()); // Print error message
            return false; // Return false if an exception is thrown
        }
    }

    protected abstract void runCommand(TaskList tasks) throws BlarneyException, IOException;
}
