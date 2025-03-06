/**
 * The {@code DeleteCommand} class handles the deletion of a task from the task list.
 * It parses the user input to extract the task index and removes the corresponding task.
 */

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

    /**
     * Executes the command by deleting the specified task from the task list.
     *
     * @param tasks The {@code TaskList} from which the task will be deleted.
     * @throws BlarneyException If an error occurs, such as an invalid index or a missing argument.
     * @throws IOException If an input/output error occurs.
     */
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
            throw new BlarneyException("there is no task to delete!" );
        } catch (NumberFormatException e) {
            throw new BlarneyException("missing integer index in the second word. key in the index, not task name.....");
        }

        System.out.println(SOLIDLINE + "I have deleted task " + (index+1) + " : " + tasks.get(index).toString());
        tasks.deleteTask(index);
    }
}
