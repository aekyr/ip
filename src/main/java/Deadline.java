import java.util.ArrayList;

public class Deadline extends Task {
    private final String type = "D";
    private String by;

    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
    }

    public Deadline(String desc, boolean isDone, String by) {
        super(desc, isDone);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + " (by: " + this.by + ")";
    }

    @Override
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = super.toTaskData();
        taskData.set(0, this.type);
        taskData.add(this.by);
        return taskData;
    }
}
