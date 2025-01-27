package tasklist;

import java.util.ArrayList;

public class TaskList {
    //    stores the list of tasks
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public String addTodo (String desc) {
        ToDo todo = new ToDo(desc);
        this.tasks.add(todo);
        return todo.toString();
    }

    public String addDeadline (String desc, String by) {
        Deadline deadline = new Deadline(desc, by);
        this.tasks.add(new Deadline(desc, by));
        return deadline.toString();
    }

    public String addEvent (String desc, String from, String to) {
        Event event = new Event(desc, from, to);
        this.tasks.add(new Event(desc, from, to));
        return event.toString();
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public int size() {
        return this.tasks.size();
    }

    public String markAsDone(int index) {
        if (!isValidIndex(index)) {
            return "Index out of bounds.";
        } else if (this.tasks.get(index).isDone()) {
            return "Task is already marked as done!";
        } else {
            this.tasks.get(index).markAsDone();
            return "Nice! I've marked this task as done:\n  "
                    + this.tasks.get(index).toString();
        }
    }

    public String markAsUndone(int index) {
        if (!isValidIndex(index)) {
            return "Index out of bounds.";
        } else if (!this.tasks.get(index).isDone()) {
            return "Task is already marked as not done!";
        } else {
            this.tasks.get(index).markAsUndone();
            return "Ok, I've marked this task as not yet done:\n  "
                    + this.tasks.get(index).toString();
        }
    }

    public String delete(int index) {
        if (!isValidIndex(index)) {
            return "Index out of bounds.";
        } else {
            Task task = this.tasks.get(index);
            this.tasks.remove(index);
            return "Noted. I've removed this task:\n  "
                    + task.toString()
                    + "\nNow you have " + this.tasks.size() + " tasks in the list.";
        }
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < this.tasks.size();
    }

    public String toString() {
        if (this.tasks.isEmpty()) {
            return "There are no tasks in the list.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list:\n");
        for (int i = 0; i < this.tasks.size(); i++) {
            sb.append(i + 1).append(". ")
                    .append(this.tasks.get(i).toString());
            if (i != this.tasks.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }


}
