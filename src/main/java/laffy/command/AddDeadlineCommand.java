package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidDatetimeFormat;
import laffy.command.exceptions.MissingKeywordFlag;
import laffy.command.exceptions.TooManyArguments;
import laffy.tasklist.TaskDateAPI;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class AddDeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";

    private final String desc;
    private final String by;

    public AddDeadlineCommand(String args)
            throws BlankArgument, InvalidDatetimeFormat, MissingKeywordFlag, TooManyArguments {
        super(args);
        super.checkKeywordFlagIsPresent(args, "/by");
        String[] arr = args.split(" /by ");
        if (arr.length < 2) {
            this.isValid = false;
            throw new BlankArgument("Description and deadline cannot be empty.\n" + getUsage());
        } else if (arr.length > 2) {
            this.isValid = false;
            throw new TooManyArguments("Expected one \"/by\" but got many instead.\n" + getUsage());
        } else {
            this.desc = arr[0].trim();
            this.by = arr[1].trim();
            this.isValid = !this.desc.isBlank() && !this.desc.isEmpty()
                    && !this.by.isBlank() && !this.by.isEmpty();
            if (!this.isValid) {
                throw new BlankArgument("Description and deadline cannot be empty.\n" + getUsage());
            }
        }
        this.isValid = TaskDateAPI.isValidDateTime(this.by);
        if (!this.isValid) {
            throw new InvalidDatetimeFormat(this.by);
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        ui.echo("Got it. I've added this task:\n  "
                + taskList.addDeadline(desc, by)
                + "\nNow you have " + taskList.size() + " tasks in the list.");
        super.execute(taskList, ui, storage);
    }


    public static String getDescription() {
        return COMMAND_WORD + " <description> /by <deadline: dd-MM-yy[ HHMM]>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }
}
