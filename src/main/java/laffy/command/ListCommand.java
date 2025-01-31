package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

/**
 * Represents a command to list all tasks.
 */
public class ListCommand extends Command {
    private static final CommandWord COMMAND_WORD = CommandWord.LIST;

    /**
     * Constructor for ListCommand.
     *
     * @param args The arguments to be parsed.
     */
    public ListCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        ui.echo(taskList.toString());
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return getCommandWord();
    }

    public String getUsage() {
        return super.getUsage() + getDescription() ;
    }

    public static String getCommandWord() {
        return COMMAND_WORD.toString();
    }
}
