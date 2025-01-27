public class DeleteCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand(TaskList taskList, Storage storage, String args) {
        super(taskList, storage, args);
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            String result = super.taskList.delete(this.index);
            super.execute();
            return result;
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}