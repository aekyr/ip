package laffy;

import laffy.command.*;
import laffy.command.exceptions.LaffyException;

public class Parser {

    /**
     * Parses the first word in full command string, attempts to instantiate
     * the corresponding Command object using the reaminder words in the full
     * command string.
     *
     * @param fullCommand The full command string.
     * @return The corresponding Command object.
     * @throws LaffyException If the command is invalid.
     */
    public static Command parse(String fullCommand)
            throws LaffyException {
        String[] cmdArgs = fullCommand.split(" ", 2);
        String keyword = cmdArgs[0];
        String args = "";
        if (cmdArgs.length == 2) {
            args = cmdArgs[1];
        }
        return switch (keyword) {
            case ExitCommand.COMMAND_WORD -> new ExitCommand(args);
            case ListCommand.COMMAND_WORD -> new ListCommand(args);
            case MarkCommand.COMMAND_WORD -> new MarkCommand(args);
            case UnmarkCommand.COMMAND_WORD -> new UnmarkCommand(args);
            case AddTodoCommand.COMMAND_WORD -> new AddTodoCommand(args);
            case AddDeadlineCommand.COMMAND_WORD -> new AddDeadlineCommand(args);
            case AddEventCommand.COMMAND_WORD -> new AddEventCommand(args);
            case DeleteCommand.COMMAND_WORD -> new DeleteCommand(args);
            default -> new InvalidCommand(args);
        };
    }
}
