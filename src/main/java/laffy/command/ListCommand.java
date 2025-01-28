package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public ListCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        ui.echo(taskList.toString());
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public String getUsage() {
        return super.getUsage() + getDescription() ;
    }
}
