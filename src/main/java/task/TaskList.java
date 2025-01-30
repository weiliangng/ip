package task;
import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {  // Inherits from ArrayList<Task>

    public TaskList() {
        super();  // Calls the ArrayList constructor
    }

    public void addTask(Task newTask) {
        this.add(newTask);  // Directly use ArrayList's add() method
    }

    public void markTask(int index, boolean isDone) {
        this.get(index).setIsDone(isDone);  // Get task from 'this' list and update it
    }
}
