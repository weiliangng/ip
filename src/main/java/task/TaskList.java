package task;
import java.util.ArrayList;
import java.util.List;

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

    public void deleteTask(int index) {
        this.remove(index);
    }

    public List<Task> findTask(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : this) {
            if (task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
