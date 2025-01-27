public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    public ExitCommand() {
        super();
        this.isValid = true;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        super.execute(taskList, ui, storage);
        return "Bye. Hope to see you again soon!";
    }

    @Override
    public boolean isExit() {
        return true;
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public static String getUsage() {
        return "Exits Application";
    }

}
