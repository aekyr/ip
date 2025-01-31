package laffy.tasklist.tasks;

import laffy.tasklist.TaskDateAPI;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Represents a task with a start and end time, i.e. an event
 * in the task list.
 */
public class Event extends Task {
    private final String TYPE = "E";
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Event(String desc, LocalDateTime from, LocalDateTime to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    public Event(String desc, boolean isDone, LocalDateTime from, LocalDateTime to) {
        super(desc, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[" + this.TYPE + "]" + super.toString()
                + " (from: " + TaskDateAPI.formatDateTime(this.from)
                + " to: " + TaskDateAPI.formatDateTime(this.to) +  ")";
    }

    @Override
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = super.toTaskData();
        taskData.set(0, this.TYPE);
        taskData.add(TaskDateAPI.formatForStorage(this.from));
        taskData.add(TaskDateAPI.formatForStorage(this.to));
        return taskData;
    }
}
