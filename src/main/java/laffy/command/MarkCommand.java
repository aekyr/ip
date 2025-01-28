package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidIndex;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

public class MarkCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "mark";

    /**
     * Constructor for MarkCommand.
     *
     * @param args The arguments to be parsed.
     * @throws InvalidIndex If the index is invalid.
     * @throws BlankArgument If the index is empty.
     */
    public MarkCommand(String args) throws InvalidIndex, BlankArgument {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        String result = taskList.markAsDone(this.index);
        super.execute(taskList, ui, storage);
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }

}
