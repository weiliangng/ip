/**
 * The {@code MarkCommand} class handles marking a task as completed in the task list.
 * It parses the user input to extract the task index and updates the task status accordingly.
 */

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


    /**
     * Executes the command by marking the specified task as completed.
     *
     * @param tasks The {@code TaskList} containing the task to be marked.
     * @throws BlarneyException If an error occurs, such as an invalid index or missing argument.
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
