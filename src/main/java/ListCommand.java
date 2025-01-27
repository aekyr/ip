public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand(TaskList taskList, Storage storage) {
        super(taskList, storage);
    }

    @Override
    public String execute() {
        String result = super.taskList.toString();
        super.execute();
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription() ;
    }
}
