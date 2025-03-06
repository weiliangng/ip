/**
 * The {@code Event} class represents a task with a specific start and end date.
 * It extends the {@code Task} class and includes additional attributes for event scheduling.
 */
package task;

public class Event extends Task {
    protected String startDate;
    protected String endDate;

    public Event(String description, String startDate, String endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {return endDate;}

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (begins: " + startDate + ", ends: " + endDate + ")";
    }






}
