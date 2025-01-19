import java.util.ArrayList;

public class List {
    //    stores the list of tasks
    private ArrayList<Task> tasks;

    public List() {
        this.tasks = new ArrayList<>();
    }

    public ToDo addTodo (String desc) {
        ToDo todo = new ToDo(desc);
        this.tasks.add(todo);
        return todo;
    }

    public Deadline addDeadline (String desc, String by) {
        Deadline deadline = new Deadline(desc, by);
        this.tasks.add(new Deadline(desc, by));
        return deadline;
    }

    public Event addEvent (String desc, String from, String to) {
        Event event = new Event(desc, from, to);
        this.tasks.add(new Event(desc, from, to));
        return event;
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public void markAsDone(int index) {
        this.tasks.get(index).markAsDone();
    }

    public void markAsUndone(int index) {
        this.tasks.get(index).markAsUndone();
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < this.tasks.size();
    }

    public String toString() {
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
