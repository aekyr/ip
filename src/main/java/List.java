import java.util.ArrayList;

public class List {
    //    stores the list of tasks
    private ArrayList<Task> tasks;

    public List() {
        this.tasks = new ArrayList<>();
    }

    public void add(String desc) {
        this.tasks.add(new Task(desc));
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            sb.append(i + 1).append(". ")
                    .append(this.tasks.get(i).toString());
            if (i != this.tasks.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }


}
