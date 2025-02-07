package command;

import task.TaskList;

import static params.Constants.SOLIDLINE;

public class ListCommand extends Command {
    public ListCommand() {
        super();
    }

    @Override
    public void execute(TaskList tasks) {
        System.out.print(SOLIDLINE);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.print(SOLIDLINE);
    }
}
