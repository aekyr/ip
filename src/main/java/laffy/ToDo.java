package laffy;

import java.util.ArrayList;

public class ToDo extends Task {
    private final String type = "T";

    public ToDo(String desc) {
        super(desc);
    }

    public ToDo(String desc, boolean isDone) {
        super(desc, isDone);
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString();
    }

    @Override
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = super.toTaskData();
        taskData.set(0, this.type);
        return taskData;
    }
}
