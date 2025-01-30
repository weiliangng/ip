package command;

import task.Task;
import task.TaskList;
import exception.BlarneyException;

import java.io.IOException;

import static params.Constants.SOLIDLINE;

public class UnmarkCommand extends Command {
    private final String args;

    public UnmarkCommand(String args) {
        super(args);
        this.args = args;
    }

    @Override
    public void execute(TaskList tasks) throws BlarneyException, IOException {
        int index;
        try {
            index = Integer.parseInt(args);
            // This is the user index starting from 1
            index--;
            if(index < 0 || index + 1 > tasks.size()) {
                throw new BlarneyException("out of index!");
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new BlarneyException("there is no task to unmark!" );
        } catch (NumberFormatException e) {
            throw new BlarneyException("missing number index in the second word. ");
        }
        tasks.markTask(index,false);
        System.out.println(SOLIDLINE + "I have marked this as " +
                (tasks.get(index).getIsDone() ? "done: " : "not done yet: "));
        System.out.println("[" + tasks.get(index).getStatusIcon() + "] " +
                tasks.get(index).getDescription() + SOLIDLINE);
    }
}
