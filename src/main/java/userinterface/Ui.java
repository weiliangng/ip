package userinterface;

import task.Task;
import java.util.ArrayList;

public class Ui {
    public void showTasks(ArrayList<Task> tasks) {
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println( (i+1) + ". " + tasks.get(i).toString() );
        }
    }

    public void showMarked(Task task) {
        System.out.println("I have marked this as " + (task.getIsDone() ? "done: " : "not done yet: "));
        System.out.println("[" + task.getStatusIcon() + "] " + task.getDescription());
    }
}
