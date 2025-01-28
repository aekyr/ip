package laffy.command;

import laffy.Storage;
import laffy.TaskList;
import laffy.Ui;

public class DeleteCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        if (!isValid) {
            return "Index must be an integer.\n" + getUsage();
        } else {
            String result = taskList.delete(this.index);
            super.execute(taskList, ui, storage);
            return result;
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <index>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}