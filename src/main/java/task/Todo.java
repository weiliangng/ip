/**
 * The {@code Todo} class represents a task without a specific deadline or event duration.
 * It extends the {@code Task} class and is identified with a "[T]" tag when displayed.
 */

package task;

public class Todo extends Task {

    public Todo(String description){
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
