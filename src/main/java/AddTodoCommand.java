public class AddTodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private String desc;

    public AddTodoCommand(List list, String args) {
        super(list);
        if (args.isEmpty() || args.isBlank()) {
            this.isValid = false;
        } else {
            this.isValid = true;
        }
        this.desc = args;
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Description cannot be empty.\n" + getUsage();
        } else {
            return "Got it. I've added this task:\n  "
                    + super.list.addTodo(desc)
                    + "\nNow you have " + super.list.size() + " tasks in the list.";
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
