public class MarkCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "mark";

    public MarkCommand(List list, String args) {
        super(list, args);
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            return super.list.markAsDone(this.index);
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }

}
