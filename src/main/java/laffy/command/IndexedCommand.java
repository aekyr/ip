package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidIndex;
import laffy.tasklist.TaskList;
import laffy.tasklist.exceptions.TasklistException;
import laffy.Ui;

public class IndexedCommand extends Command {
    protected final int index;
    public static final String COMMAND_WORD = "indexed";

    public IndexedCommand(String args) throws InvalidIndex, BlankArgument {
        super(args);
        if (args.isEmpty()) {
            this.index = -1;
            this.isValid = false;
            throw new BlankArgument("Index cannot be empty.\n" + this.getUsage());
        }
        try {
            Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            this.index = -1;
            this.isValid = false;
            throw new InvalidIndex("Expected an integer but got " + args);
        }
        this.isValid = true;
        this.index = Integer.parseInt(args.trim()) - 1;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        super.execute(taskList, ui, storage);
    }


}
