public class AddDeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    private String desc;
    private String by;
    private String whyInvalid = "";

    public AddDeadlineCommand(TaskList taskList, String args) {
        super(taskList);
        String[] arr = args.split(" /by ");
        if (arr.length == 2) {
            this.desc = arr[0];
            this.by = arr[1];
            this.isValid = !this.desc.isBlank() && !this.desc.isEmpty()
                    && !this.by.isBlank() && !this.by.isEmpty();
            if (!this.isValid) {
                this.whyInvalid = "Description and deadline cannot be empty.\n";
            }
            this.isValid = isValid && TaskDateAPI.isValidDateTime(this.by);
            if (!this.isValid) {
                this.whyInvalid = "Invalid deadline format. Please use dd-MM-yy[ HHMM].\n";
            }
        } else {
            this.whyInvalid = "Description and deadline cannot be empty.\n";
            this.isValid = false;
        }
    }

    @Override
    public String execute() {
        if (!isValid) {
            return this.whyInvalid + getUsage();
        } else {
            return "Got it. I've added this task:\n  "
                    + super.taskList.addDeadline(desc, by)
                    + "\nNow you have " + super.taskList.size() + " tasks in the list.";
        }
    }


    public static String getDescription() {
        return COMMAND_WORD + " <description> /by <deadline: dd-MM-yy[ HHMM]>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
