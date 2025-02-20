package command;

import task.Task;
import task.TaskList;
import exception.BlarneyException;

import java.io.IOException;

import static params.Constants.SOLIDLINE;

public class MarkCommand extends Command {
    private final String args;

    public MarkCommand(String args) {
        super(args);
        this.args = args;
    }

    @Override
    public void runCommand(TaskList tasks) throws BlarneyException, IOException {
        int index;
        try {
            index = Integer.parseInt(args);
            // This is the user index starting from 1
            index--;
            if(index < 0 || index + 1 > tasks.size()) {
                throw new BlarneyException("out of index! key in index, not task name.....");
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new BlarneyException("there is no task to mark!" );
        } catch (NumberFormatException e) {
            throw new BlarneyException("missing number index in the second word. key in index, not task name.....");
        }
        tasks.markTask(index,true);
        System.out.println(SOLIDLINE + "I have marked task " + (index+1) + " as " +
                (tasks.get(index).getIsDone() ? "done: " : "not done yet: "));
        System.out.println(tasks.get(index));
    }
}
