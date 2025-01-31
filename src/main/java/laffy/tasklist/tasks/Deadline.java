package laffy.tasklist.tasks;

import laffy.tasklist.TaskDateAPI;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a task with a deadline.
 * Contains a description and a deadline.
 */
public class Deadline extends Task {
    private final String TYPE = "D";
    private final LocalDateTime by;

    public Deadline(String desc, LocalDateTime by) {
        super(desc);
        this.by = by;
    }

    public Deadline(String desc, boolean isDone, LocalDateTime by) {
        super(desc, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[" + this.TYPE + "]" + super.toString()
                + " (by: " + TaskDateAPI.formatDateTime(this.by) + ")";
    }

    @Override
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = super.toTaskData();
        taskData.set(0, this.TYPE);
        taskData.add(TaskDateAPI.formatForStorage(this.by));
        return taskData;
    }
}
