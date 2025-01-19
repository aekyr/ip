public class ListCommandParser {
    private List list;

    public ListCommandParser(List list) {
        this.list = list;
    }

    public Command parse(String keyword, String args) {
        Command command = null;
        switch (keyword) {
            case "list":
                command = new ListCommand(this.list);
                break;
            case "mark":
                command = new MarkCommand(this.list, args);
                break;
            case "unmark":
                command = new UnmarkCommand(this.list, args);
                break;
            case "todo":
                command = new AddTodoCommand(this.list, args);
                break;
            case "deadline":
                command = new AddDeadlineCommand(this.list, args);
                break;
            case "event":
                command = new AddEventCommand(this.list, args);
                break;
            default:
                command = new InvalidCommand(this.list);
        }
        return command;
    }
}
