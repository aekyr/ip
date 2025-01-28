package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidIndex;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class MarkCommand extends IndexedCommand {
    private static final String COMMAND_WORD = "mark";

    public MarkCommand(String args) throws InvalidIndex, BlankArgument {
        super(args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        ui.echo(taskList.markAsDone(super.getIndex()));
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }

    public static String getCommandWord() {
        return COMMAND_WORD;
    }
}
