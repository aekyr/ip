package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    /**
     * Constructor for ListCommand.
     *
     * @param args The arguments to be parsed.
     */
    public ListCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        String result = taskList.toString();
        super.execute(taskList, ui, storage);
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD;
    }

    public String getUsage() {
        return super.getUsage() + getDescription() ;
    }
}
