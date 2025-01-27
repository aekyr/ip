public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand() {
        super();
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        String result = taskList.toString();
        super.execute(taskList, ui, storage);
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription() ;
    }
}
