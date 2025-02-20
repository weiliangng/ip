package command;

import exception.BlarneyException;
import task.TaskList;

import java.io.IOException;
import static params.Constants.SOLIDLINE;
public class ByeCommand extends Command {

    public ByeCommand() {
        super();
    }

    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        System.out.println(SOLIDLINE + "\nBlarney blunders away\n" + SOLIDLINE);
        System.exit(0);
    }
}
