package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.BlankArgument;
import laffy.command.exceptions.InvalidDatetimeFormat;
import laffy.command.exceptions.MissingKeywordFlag;
import laffy.tasklist.TaskDateAPI;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TaskListException;

public class AddEventCommand extends Command {
    public static final String COMMAND_WORD = "event";

    private String desc;
    private String from;
    private String to;

    /**
     * Constructor for AddEventCommand.
     *
     * @param args The arguments to be parsed.
     * @throws BlankArgument If the description, from, or to is empty.
     * @throws InvalidDatetimeFormat If the from or to is not in the correct format.
     * @throws MissingKeywordFlag If the keyword flag is not present in the command.
     */
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
        this.isValid = isValid && TaskDateAPI.isValidDateTime(this.from)
                && TaskDateAPI.isValidDateTime(this.to);
        if (!this.isValid) {
            throw new InvalidDatetimeFormat(this.from + " and " + this.to);
        }

    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws TaskListException {
        String result = "Got it. I've added this task:\n  "
                + taskList.addEvent(desc, from, to)
                + "\nNow you have " + taskList.size() + " tasks in the list.";
        super.execute(taskList, ui, storage);
        return result;
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description> /from <start time: dd-MM-yy[ HHMM]> /to <end time: dd-MM-yy[ HHMM]>";
    }

    public String getUsage() {
        return super.getUsage() + getDescription();
    }
}
