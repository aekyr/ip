public class ListCommandParser {
    private List list;

    public ListCommandParser(List list) {
        this.list = list;
    }

    public Command parse(String keyword, String args) {
        Command command = null;
        switch (keyword) {
            case ListCommand.COMMAND_WORD:
                command = new ListCommand(this.list);
                break;
            case MarkCommand.COMMAND_WORD:
                command = new MarkCommand(this.list, args);
                break;
            case UnmarkCommand.COMMAND_WORD:
                command = new UnmarkCommand(this.list, args);
                break;
            case AddTodoCommand.COMMAND_WORD:
                command = new AddTodoCommand(this.list, args);
                break;
            case AddDeadlineCommand.COMMAND_WORD:
                command = new AddDeadlineCommand(this.list, args);
                break;
            case AddEventCommand.COMMAND_WORD:
                command = new AddEventCommand(this.list, args);
                break;
            case DeleteCommand.COMMAND_WORD:
                command = new DeleteCommand(this.list, args);
                break;
            default:
                command = new InvalidCommand(this.list);
        }
        return command;
    }
}
