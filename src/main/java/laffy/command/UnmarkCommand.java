package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidIndex;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends IndexedCommand {
    private static final CommandWord COMMAND_WORD = CommandWord.UNMARK;

    /**
     * Constructor for UnmarkCommand.
     *
     * @param args The arguments to be parsed.
     * @throws InvalidIndex If the index is invalid.
     * @throws BlankArgument If the index is empty.
     */
    public UnmarkCommand(String args) throws InvalidIndex, BlankArgument {
        super(args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        ui.echo(taskList.markAsUndone(super.getIndex()));
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return getCommandWord() + " <index>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }

    public static String getCommandWord() {
        return COMMAND_WORD.toString();
    }
}
