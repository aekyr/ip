package laffy.command;

import laffy.Storage;
import laffy.Ui;
import laffy.command.exceptions.BlankArgument;
import laffy.tasklist.TaskList;
import laffy.tasklist.exceptions.TasklistException;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";

    private String toFind;

    /**
     * Constructor for FindCommand.
     *
     * @param args The arguments to be parsed.
     */
    public FindCommand(String args) throws BlankArgument {
        super(args);
        if (args.isEmpty() || args.isBlank()) {
            this.isValid = false;
            throw new BlankArgument("Search keyword cannot be empty.\n" + getUsage());
        }
        this.toFind = args.trim();
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        String result = taskList.find(this.toFind);
        super.execute(taskList, ui, storage);
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD + " <keyword>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }
}
