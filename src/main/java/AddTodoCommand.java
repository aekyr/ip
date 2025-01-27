public class AddTodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private String desc;

    public AddTodoCommand(TaskList taskList, String args) {
        super(taskList);
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
                    + super.taskList.addTodo(desc)
                    + "\nNow you have " + super.taskList.size() + " tasks in the list.";
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
