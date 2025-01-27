public class ListCommandParser {
    private TaskList taskList;

    public ListCommandParser(TaskList taskList) {
        this.taskList = taskList;
    }

    public Command parse(String keyword, String args) {
        Command command = null;
        switch (keyword) {
        case ListCommand.COMMAND_WORD:
            command = new ListCommand(this.taskList);
            break;
        case MarkCommand.COMMAND_WORD:
            command = new MarkCommand(this.taskList, args);
            break;
        case UnmarkCommand.COMMAND_WORD:
            command = new UnmarkCommand(this.taskList, args);
            break;
        case AddTodoCommand.COMMAND_WORD:
            command = new AddTodoCommand(this.taskList, args);
            break;
        case AddDeadlineCommand.COMMAND_WORD:
            command = new AddDeadlineCommand(this.taskList, args);
            break;
        case AddEventCommand.COMMAND_WORD:
            command = new AddEventCommand(this.taskList, args);
            break;
        case DeleteCommand.COMMAND_WORD:
            command = new DeleteCommand(this.taskList, args);
            break;
        default:
            command = new InvalidCommand(this.taskList);
        }
        return command;
    }
}
