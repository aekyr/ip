package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    public ExitCommand(String args) {
        super(args);
        this.isValid = true;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        super.execute(taskList, ui, storage);
        ui.echo("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public String getUsage() {
        return "Exits Application";
    }

}
