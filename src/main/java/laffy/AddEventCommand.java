package laffy;

public class AddEventCommand extends Command {
    public static final String COMMAND_WORD = "event";
    private String desc;
    private String from;
    private String to;
    private String whyInvalid = "";

    public AddEventCommand(String args) {
        String[] arr = args.split(" /from ");
        if (arr.length == 2) {
            String[] arr2 = arr[1].split(" /to ");
            if (arr2.length == 2) {
                this.desc = arr[0];
                this.from = arr2[0];
                this.to = arr2[1];
                this.isValid = !this.desc.isBlank() && !this.desc.isEmpty()
                        && !this.from.isBlank() && !this.from.isEmpty()
                        && !this.to.isBlank() && !this.to.isEmpty();
                if (!this.isValid) {
                    this.whyInvalid = "Description, start time and end time cannot be empty.\n";
                }
                this.isValid = isValid && TaskDateAPI.isValidDateTime(this.from)
                        && TaskDateAPI.isValidDateTime(this.to);
                if (!this.isValid) {
                    this.whyInvalid = "Invalid start time or end time format. Please use dd-MM-yy[ HHMM].\n";
                }
            } else {
                this.whyInvalid = "Description, start time and end time cannot be empty.\n";
                this.isValid = false;
            }
        } else {
            this.whyInvalid = "Description, start time and end time cannot be empty.\n";
            this.isValid = false;
        }
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        if (!isValid) {
            return this.whyInvalid + getUsage();
        } else {
            String result = "Got it. I've added this task:\n  "
                    + taskList.addEvent(desc, from, to)
                    + "\nNow you have " + taskList.size() + " tasks in the list.";
            super.execute(taskList, ui, storage);
            return result;
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description> /from <start time: dd-MM-yy[ HHMM]> /to <end time: dd-MM-yy[ HHMM]>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
