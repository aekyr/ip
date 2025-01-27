abstract class Command {
    protected final TaskList taskList;
    protected final Storage storage;
    public boolean isValid;
    public static final String COMMAND_WORD = "command";

    public Command (TaskList taskList, Storage storage) {
        this.taskList = taskList;
        this.storage = storage;
        this.isValid = false;
    }
    public String execute() {
        // executes after all children have done so
        this.storage.saveData(this.taskList.toTasksData());
        return "";
    };

    public static String getDescription() {
        return "";
    }

    public static String getUsage() {
        return "Usage: " ;
    }
}
