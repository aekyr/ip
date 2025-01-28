package laffy.tasklist.tasks;

import java.util.ArrayList;

public class Task {
    private String type = "I";
    private String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    public Task(String desc, boolean isDone) {
        this.desc = desc;
        this.isDone = isDone;
    }

    public String getDescription() {
        return this.desc;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
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
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.getStatusIcon()).append("] ").append(this.desc);
        return sb.toString();
    }

    public ArrayList<String> toTaskData() {
        ArrayList<String> taskData = new ArrayList<>();
        taskData.add(this.type);
        taskData.add(this.isDone ? "1" : "0");
        taskData.add(this.desc);
        return taskData;
    }
}
