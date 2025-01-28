package laffy.tasklist.tasks;

import java.util.ArrayList;

public class Task {
    private final String type = "I";
    private final String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    public Task(String desc, boolean isDone) {
        this.desc = desc;
        this.isDone = isDone;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getDescription() {
        return this.desc;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }

    /**
     * Converts the task to data format.
     * The data format is a list of strings, where each string
     * represents a field of the task. Used by Storage to save data to file.
     *
     * @return The data of the task.
     */
    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = new ArrayList<>();
        taskData.add(this.type);
        taskData.add(this.isDone ? "1" : "0");
        taskData.add(this.desc);
        return taskData;
    }
}
