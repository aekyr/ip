import java.time.LocalDateTime;
import java.util.ArrayList;

public class Deadline extends Task {
    private final String type = "D";
    private LocalDateTime by;

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
        return "[" + this.type + "]" + super.toString()
                + " (by: " + TaskDateAPI.formatDateTime(this.by) + ")";
    }

    @Override
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = super.toTaskData();
        taskData.set(0, this.type);
        taskData.add(TaskDateAPI.formatForStorage(this.by));
        return taskData;
    }
}
