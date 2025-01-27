public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand(TaskList taskList) {
        super(taskList);
    }

    @Override
    public String execute() {
        return super.taskList.toString();
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription() ;
    }
}
