package command;

import exception.BlarneyException;
import task.Task;
import task.TaskList;

import java.util.List;

import static params.Constants.SOLIDLINE;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String args) {
        super(args);
        keyword = args;
    }

    @Override
    public void runCommand(TaskList tasks) throws BlarneyException {
        List<Task> foundTasks = tasks.findTask(keyword);//args wont work cause arg is private in Command
        System.out.print(SOLIDLINE);

        if (foundTasks.isEmpty()) {
            System.out.println("No task found");
        }

        for (int i = 0; i < foundTasks.size(); i++) {
            System.out.println((i + 1) + ". " + foundTasks.get(i).toString());
        }
        System.out.print(SOLIDLINE);

    }
}