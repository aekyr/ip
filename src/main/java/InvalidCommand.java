public class InvalidCommand extends Command {
    public static final String COMMAND_WORD = "invalid";

    public InvalidCommand(List list) {
        super(list);
        this.isValid = true;
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getUsage());
        sb.append("\n");
        sb.append("Here are the available commands:");
        sb.append("\n1. ");
        sb.append(ListCommand.getDescription());
        sb.append("\n2. ");
        sb.append(AddTodoCommand.getDescription());
        sb.append("\n3. ");
        sb.append(AddDeadlineCommand.getDescription());
        sb.append("\n4. ");
        sb.append(AddEventCommand.getDescription());
        sb.append("\n5. ");
        sb.append(MarkCommand.getDescription());
        sb.append("\n6. ");
        sb.append(UnmarkCommand.getDescription());
        sb.append("\n7. ");
        sb.append(DeleteCommand.getDescription());


        return sb.toString();
    }

    public static String getDescription() {
        return "";
    }

    public static String getUsage() {
        return "Invalid command. Please enter a valid command.";
    }
}
