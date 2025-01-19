public class Task {
    private String desc;

    public Task(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
