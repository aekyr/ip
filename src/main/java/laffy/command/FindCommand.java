package laffy.command;

import laffy.Storage;
import laffy.Ui;
import laffy.command.exceptions.BlankArgument;
import laffy.tasklist.TaskList;
import laffy.tasklist.exceptions.TaskListException;

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
            this.setValid(false);
            throw new BlankArgument("Search keyword cannot be empty.\n" + getUsage());
        }
        this.toFind = args.trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        ui.echo(taskList.find(this.toFind));
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return COMMAND_WORD + " <keyword>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }

    public static String getCommandWord() {
        return COMMAND_WORD;
    }
}
