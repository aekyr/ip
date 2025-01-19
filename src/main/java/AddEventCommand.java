public class AddEventCommand extends Command {
    private String desc;
    private String from;
    private String to;

    public AddEventCommand(List list, String args) {
        super(list);
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
            } else {
                this.isValid = false;
            }
        } else {
            this.isValid = false;
        }
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Description and time range cannot be empty.\nUsage: event <description> /from <start time> /to <end time>";
        } else {
            return "Got it. I've added this task:\n  "
                    + super.list.addEvent(desc, from, to)
                    + "\nNow you have " + super.list.size() + " tasks in the list.";
        }
    }
}
