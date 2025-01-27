class UnmarkCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "unmark";

    public UnmarkCommand(TaskList taskList, Storage storage, String args) {
        super(taskList, storage, args);
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            return super.taskList.markAsUndone(this.index);
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
