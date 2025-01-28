package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

public class ExitCommand extends Command {
    private static final String COMMAND_WORD = "bye";

    /**
     * Constructor for ExitCommand.
     *
     * @param args The arguments to be parsed.
     */
    public ExitCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
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

    public static String getCommandWord() {
        return COMMAND_WORD;
    }

}
