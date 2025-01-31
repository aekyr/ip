package laffy;

import laffy.command.*;

import laffy.command.exceptions.LaffyException;

/**
 * Represents a parser that parses the full command string into a Command object.
 */
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
        return switch (CommandWord.fromString(keyword)) {
            case EXIT -> new ExitCommand(args);

            case LIST -> new ListCommand(args);
            case MARK -> new MarkCommand(args);
            case UNMARK -> new UnmarkCommand(args);

            case TODO -> new AddTodoCommand(args);
            case DEADLINE -> new AddDeadlineCommand(args);
            case EVENT -> new AddEventCommand(args);

            case DELETE -> new DeleteCommand(args);
            case FIND -> new FindCommand(args);

            case INVALID -> new InvalidCommand(args);
        };

    }
}
