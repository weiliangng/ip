package command;

import exception.BlarneyException;
import task.TaskList;

import java.io.IOException;

import static params.Constants.SOLIDLINE;

public class DeleteCommand extends Command {

    private final String args;
    public DeleteCommand(String args) {
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
                throw new BlarneyException("out of index! key in index, not task name.....");
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new BlarneyException("there is no task to delete!" );
        } catch (NumberFormatException e) {
            throw new BlarneyException("missing integer index in the second word. key in the index, not task name.....");
        }

        System.out.println(SOLIDLINE + "I have deleted task " + (index+1) + " : " + tasks.get(index).toString());
        tasks.deleteTask(index);
    }
}
