package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "bye";

    /**
     * Constructor for ExitCommand.
     *
     * @param args The arguments to be parsed.
     */
    public ExitCommand(String args) {
        super(args);
        this.isValid = true;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        super.execute(taskList, ui, storage);
        return "Bye. Hope to see you again soon!";
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
