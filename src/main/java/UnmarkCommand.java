public class UnmarkCommand extends MarkCommand {
    public static final String COMMAND_WORD = "unmark";

    public UnmarkCommand(List list, String args) {
        super(list, args);
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            return super.list.markAsUndone(this.index);
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
