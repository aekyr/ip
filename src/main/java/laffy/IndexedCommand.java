package laffy;

public class IndexedCommand extends Command {
    protected final int index;
    public static final String COMMAND_WORD = "indexed";

    public IndexedCommand(String args) {
        super();
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
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            String result = "";
            super.execute(taskList, ui, storage);
            return result;
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
