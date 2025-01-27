abstract class Command {
    public boolean isValid;
    public static final String COMMAND_WORD = "command";

    public Command () {
        this.isValid = false;
    }
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        // executes after all children have done so
        storage.saveData(taskList.toTasksData());
        return "";
    };

    public boolean isExit() {
        return false;
    }

    public static String getDescription() {
        return "";
    }

    public static String getUsage() {
        return "Usage: " ;
    }

}
