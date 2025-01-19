public class MarkCommand extends Command {
    protected final int index;
    public static final String COMMAND_WORD = "mark";

    public MarkCommand(List list, String args) {
        super(list);
        try {
            Integer.parseInt(args);
        } catch (NumberFormatException e) {
            this.index = -1;
            this.isValid = false;
            return;
        }
        this.isValid = true;
        this.index = Integer.parseInt(args) - 1;
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
