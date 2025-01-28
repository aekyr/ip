package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidIndex;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class DeleteCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand(String args) throws InvalidIndex, BlankArgument {
        super(args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        ui.echo(taskList.delete(this.index));
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }
}