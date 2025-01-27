public class Parser {
    private final TaskList taskList;
    private final Storage storage;

    public Parser(TaskList taskList, Storage storage) {
        this.taskList = taskList;
        this.storage = storage;
    }

    public Command parse(String keyword, String args) {
        return switch (keyword) {
            case ListCommand.COMMAND_WORD -> new ListCommand(this.taskList, this.storage);
            case MarkCommand.COMMAND_WORD -> new MarkCommand(this.taskList, this.storage, args);
            case UnmarkCommand.COMMAND_WORD -> new UnmarkCommand(this.taskList, this.storage, args);
            case AddTodoCommand.COMMAND_WORD -> new AddTodoCommand(this.taskList, this.storage, args);
            case AddDeadlineCommand.COMMAND_WORD -> new AddDeadlineCommand(this.taskList, this.storage, args);
            case AddEventCommand.COMMAND_WORD -> new AddEventCommand(this.taskList, this.storage, args);
            case DeleteCommand.COMMAND_WORD -> new DeleteCommand(this.taskList, this.storage, args);
            default -> new InvalidCommand(this.taskList, this.storage);
        };
    }
}
