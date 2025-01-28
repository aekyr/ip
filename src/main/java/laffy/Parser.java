package laffy;

import laffy.command.*;

public class Parser {

    public static Command parse(String fullCommand) {
        String[] cmdArgs = fullCommand.split(" ", 2);
        String keyword = cmdArgs[0];
        String args = "";
        if (cmdArgs.length == 2) {
            args = cmdArgs[1];
        }
        return switch (keyword) {
            case ExitCommand.COMMAND_WORD -> new ExitCommand();
            case ListCommand.COMMAND_WORD -> new ListCommand();
            case MarkCommand.COMMAND_WORD -> new MarkCommand(args);
            case UnmarkCommand.COMMAND_WORD -> new UnmarkCommand(args);
            case AddTodoCommand.COMMAND_WORD -> new AddTodoCommand(args);
            case AddDeadlineCommand.COMMAND_WORD -> new AddDeadlineCommand(args);
            case AddEventCommand.COMMAND_WORD -> new AddEventCommand(args);
            case DeleteCommand.COMMAND_WORD -> new DeleteCommand(args);
            default -> new InvalidCommand();
        };
    }
}
