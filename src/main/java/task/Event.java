package task;

import java.time.Duration;
import java.time.LocalDateTime;

import static params.Constants.FORMATTER;

public class Event extends Task {
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;

    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate.format(FORMATTER);
    }
    public String getEndDate() {
        return endDate.format(FORMATTER);
    }

    public String getDuration() {
        Duration duration = Duration.between(startDate, endDate);
        long hours = duration.toHours();
        return hours + " hour(s) long";
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (begins: " + getStartDate() + ", ends: " + getEndDate() + "), " + getDuration();
    }






}
