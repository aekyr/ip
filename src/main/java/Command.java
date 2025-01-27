abstract class Command {
    protected TaskList taskList;
    protected boolean isValid;
    public static final String COMMAND_WORD = "command";

    public Command (TaskList taskList) {
        this.taskList = taskList;
        this.isValid = false;
    }
    public abstract String execute();

    public static String getDescription() {
        return "";
    }

    public static String getUsage() {
        return "Usage: " ;
    }
}
