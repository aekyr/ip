public class InvalidCommand extends Command {

    public InvalidCommand(List list) {
        super(list);
        this.isValid = true;
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid command. Please enter a valid command.\n");
        sb.append("Valid commands are:\n");
        sb.append("1. list\n");
        sb.append("2. todo <description>\n");
        sb.append("3. deadline <description> /by <deadline>\n");
        sb.append("4. event <description> /at <time>\n");
        sb.append("5. mark <index>\n");
        sb.append("6. unmark <index>\n");
        sb.append("7. bye\n");

        return sb.toString();
    }
}
