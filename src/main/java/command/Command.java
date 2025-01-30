package command;
import task.TaskList;
import java.io.IOException;
import exception.BlarneyException;

public abstract class Command {
    public Command(String args) {}
    public Command() {}
    public abstract void execute(TaskList tasks) throws BlarneyException, IOException;
}
