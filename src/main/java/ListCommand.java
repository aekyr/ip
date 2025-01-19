public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand(List list) {
        super(list);
    }

    @Override
    public String execute() {
        return super.list.toString();
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription() ;
    }
}
