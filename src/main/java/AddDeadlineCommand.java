public class AddDeadlineCommand extends Command {
    private String desc;
    private String by;

    public AddDeadlineCommand(List list, String args) {
        super(list);
        String[] arr = args.split(" /by ");
        if (arr.length == 2) {
            this.desc = arr[0];
            this.by = arr[1];
            this.isValid = !this.desc.isBlank() && !this.desc.isEmpty()
                    && !this.by.isBlank() && !this.by.isEmpty();
        } else {
            this.isValid = false;
        }
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Description and deadline cannot be empty.\nUsage: deadline <description> /by <deadline>";
        } else {
            return "Got it. I've added this task:\n  "
                    + super.list.addDeadline(desc, by)
                    + "\nNow you have " + super.list.size() + " tasks in the list.";
        }
    }
}
