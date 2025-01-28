package laffy.tasklist;

import laffy.tasklist.exceptions.IndexOutOfRange;
import laffy.tasklist.tasks.Deadline;
import laffy.tasklist.tasks.Event;
import laffy.tasklist.tasks.Task;
import laffy.tasklist.tasks.ToDo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskList {
    //    stores the list of tasks
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<ArrayList<String>> tasksData) {
        this.tasks = new ArrayList<>();
        for (ArrayList<String> taskData : tasksData) {
            String taskType = taskData.get(0);
            boolean isDone = taskData.get(1).equals("1");
            String desc = taskData.get(2);
            switch (taskType) {
                case "T":
                    this.tasks.add(new ToDo(desc, isDone));
                    break;
                case "D":
                    LocalDateTime by = TaskDateAPI.parseFromStorage(taskData.get(3));
                    this.tasks.add(new Deadline(desc, isDone, by));
                    break;
                case "E":
                    LocalDateTime from = TaskDateAPI.parseFromStorage(taskData.get(3));
                    LocalDateTime to = TaskDateAPI.parseFromStorage(taskData.get(4));
                    this.tasks.add(new Event(desc, isDone, from, to));
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayList<ArrayList<String>> toTasksData() {
        ArrayList<ArrayList<String>> tasksData = new ArrayList<>();
        for (Task task : this.tasks) {
            tasksData.add(task.toTaskData());
        }
        return tasksData;
    }

    public int size() {
        return this.tasks.size();
    }

    public String addTodo(String desc) {
        ToDo todo = new ToDo(desc);
        this.tasks.add(todo);
        return todo.toString();
    }

    public String addDeadline(String desc, String byStr) {
        LocalDateTime byDateTime = TaskDateAPI.parseDateTime(byStr);
        Deadline deadline = new Deadline(desc, byDateTime);
        this.tasks.add(new Deadline(desc, byDateTime));
        return deadline.toString();
    }

    public String addEvent(String desc, String fromStr, String toStr) {
        LocalDateTime fromDateTime = TaskDateAPI.parseDateTime(fromStr);
        LocalDateTime toDateTime = TaskDateAPI.parseDateTime(toStr);
        Event event = new Event(desc, fromDateTime, toDateTime);
        this.tasks.add(new Event(desc, fromDateTime, toDateTime));
        return event.toString();
    }

    public String markAsDone(int index) throws IndexOutOfRange {
        checkIndexAndThrow(index);
        if (this.tasks.get(index).isDone()) {
            return "Task is already marked as done!";
        } else {
            this.tasks.get(index).markAsDone();
            return "Nice! I've marked this task as done:\n  "
                    + this.tasks.get(index).toString();
        }
    }

    public String markAsUndone(int index) throws IndexOutOfRange {
        checkIndexAndThrow(index);
        if (!this.tasks.get(index).isDone()) {
            return "Task is already marked as not done!";
        } else {
            this.tasks.get(index).markAsUndone();
            return "Ok, I've marked this task as not yet done:\n  "
                    + this.tasks.get(index).toString();
        }
    }

    public String delete(int index) throws IndexOutOfRange {
        checkIndexAndThrow(index);
        Task task = this.tasks.get(index);
        this.tasks.remove(index);
        return "Noted. I've removed this task:\n  "
                + task.toString()
                + "\nNow you have " + this.tasks.size() + " tasks in the list.";
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < this.size();
    }

    public void checkIndexAndThrow(int index) throws IndexOutOfRange {
        if (!isValidIndex(index)) {
            throw new IndexOutOfRange("Valid index range is 1 to " + this.tasks.size());
        }
    }

    public String toString() {
        if (this.tasks.isEmpty()) {
            return "There are no tasks in the list.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list:\n");
        int sizeMagnitude = (int) Math.log10(this.tasks.size()) + 1;
        String space = " ";
        for (int i = 0; i < this.tasks.size(); i++) {
            int iMagnitude = (int) Math.log10(i + 1) + 1;
            sb.append(i + 1)
                    .append(".").append(space.repeat(sizeMagnitude-iMagnitude + 1))
                    .append(this.tasks.get(i).toString());
            if (i != this.tasks.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }


}
