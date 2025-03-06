package command;

import exception.BlarneyException;
import task.TaskList;

import java.io.IOException;
import static params.Constants.SOLIDLINE;
public class ByeCommand extends Command {

    public ByeCommand() {
        super();
    }
    /**
     * Executes the ByeCommand, printing a farewell message and exiting the application.
     *
     * @param tasks The task list.
     * @throws BlarneyException If an error occurs during execution.
     */
    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        System.out.println(SOLIDLINE + "\nBlarney blunders away\n" + SOLIDLINE);
        System.exit(0);
    }
}
