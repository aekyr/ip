package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidDatetimeFormat;
import laffy.command.exceptions.MissingKeywordFlag;
import laffy.tasklist.TaskDateAPI;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public class AddEventCommand extends Command {
    public static final String COMMAND_WORD = "event";

    private final String desc;
    private final String from;
    private final String to;

    public AddEventCommand(String args) throws BlankArgument, MissingKeywordFlag, InvalidDatetimeFormat {
        super(args);
        super.checkKeywordFlagIsPresent(args, "/from");
        super.checkKeywordFlagIsPresent(args, "/to");
        String[] arr = args.split(" /from ");
        if (arr.length != 2) {
            this.isValid = false;
            throw new BlankArgument("Description, from, and to cannot be empty.\n" + getUsage());
        }
        String[] arr2 = arr[1].split(" /to ");
        if (arr2.length != 2) {
            this.isValid = false;
            throw new BlankArgument("Description, from, and to cannot be empty.\n" + getUsage());
        }
        this.desc = arr[0].trim();
        this.from = arr2[0].trim();
        this.to = arr2[1].trim();
        this.isValid = !this.desc.isBlank() && !this.desc.isEmpty()
                && !this.from.isBlank() && !this.from.isEmpty()
                && !this.to.isBlank() && !this.to.isEmpty();
        if (!this.isValid) {
            throw new BlankArgument("Description, from, and to cannot be empty.\n" + getUsage());
        }
        this.isValid = TaskDateAPI.isValidDateTime(this.from) && TaskDateAPI.isValidDateTime(this.to);
        if (!this.isValid) {
            throw new InvalidDatetimeFormat(this.from + " and " + this.to);
        }

    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        ui.echo("Got it. I've added this task:\n  "
                + taskList.addEvent(desc, from, to)
                + "\nNow you have " + taskList.size() + " tasks in the list.");
        super.execute(taskList, ui, storage);
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description> /from <start time: dd-MM-yy[ HHMM]> /to <end time: dd-MM-yy[ HHMM]>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }
}
