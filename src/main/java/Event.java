import java.util.ArrayList;

public class Event extends Task {
    private final String type = "E";
    private String from;
    private String to;

    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    public Event(String desc, boolean isDone, String from, String to) {
        super(desc, isDone);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + " (from: " + this.from + " to: " + this.to +  ")";
    }

    @Override
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = super.toTaskData();
        taskData.set(0, this.type);
        taskData.add(this.from);
        taskData.add(this.to);
        return taskData;
    }
}
