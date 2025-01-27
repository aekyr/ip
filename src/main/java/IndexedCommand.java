public class IndexedCommand extends Command {
    protected final int index;
    public static final String COMMAND_WORD = "indexed";

    public IndexedCommand(TaskList taskList, String args) {
        super(taskList);
        try {
            Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            this.index = -1;
            this.isValid = false;
            return;
        }
        this.isValid = true;
        this.index = Integer.parseInt(args.trim()) - 1;
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            return "";
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
