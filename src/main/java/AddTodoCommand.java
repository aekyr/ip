public class AddTodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private String desc;

    public AddTodoCommand(String args) {
        if (args.isEmpty() || args.isBlank()) {
            this.isValid = false;
        } else {
            this.isValid = true;
        }
        this.desc = args;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        if (!isValid) {
            return "Description cannot be empty.\n" + getUsage();
        } else {
            String result =  "Got it. I've added this task:\n  "
                    + taskList.addTodo(desc)
                    + "\nNow you have " + taskList.size() + " tasks in the list.";
            super.execute(taskList, ui, storage);
            return result;
        }
    }

    public static String getDescription() {
        return COMMAND_WORD + " <description>";
    }

    public static String getUsage() {
        return Command.getUsage() + getDescription();
    }
}
