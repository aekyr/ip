package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class AddTodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private final String desc;

    public AddTodoCommand(String args) throws BlankArgument {
        super(args);
        if (args.isEmpty() || args.isBlank()) {
            this.isValid = false;
            throw new BlankArgument("Description cannot be empty.\n" + getUsage());
        } else {
            this.isValid = true;
        }
        this.desc = args.trim();
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        String result =  "Got it. I've added this task:\n  "
                + taskList.addTodo(desc)
                + "\nNow you have " + taskList.size() + " tasks in the list.";
        super.execute(taskList, ui, storage);
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }
}
