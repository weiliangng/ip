/**
 * The {@code ListCommand} class handles displaying all tasks in the task list.
 * When executed, it prints the list of tasks with their respective indices.
 */

package command;

import task.TaskList;

import static params.Constants.SOLIDLINE;

public class ListCommand extends Command {
    public ListCommand() {
        super();
    }


    /**
     * Executes the command by printing all tasks in the {@code TaskList}.
     * Each task is displayed with its corresponding index.
     *
     * @param tasks The {@code TaskList} containing the tasks to be listed.
     */
    @Override
    public void runCommand(TaskList tasks) {
        System.out.print(SOLIDLINE);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.print(SOLIDLINE);
    }
}
