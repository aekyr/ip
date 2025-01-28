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
        if (keyword.equals(ExitCommand.getCommandWord())) return new ExitCommand(args);
        if (keyword.equals(ListCommand.getCommandWord())) return new ListCommand(args);
        if (keyword.equals(MarkCommand.getCommandWord())) return new MarkCommand(args);
        if (keyword.equals(UnmarkCommand.getCommandWord())) return new UnmarkCommand(args);
        if (keyword.equals(AddTodoCommand.getCommandWord())) return new AddTodoCommand(args);
        if (keyword.equals(AddDeadlineCommand.getCommandWord())) return new AddDeadlineCommand(args);
        if (keyword.equals(AddEventCommand.getCommandWord())) return new AddEventCommand(args);
        if (keyword.equals(DeleteCommand.getCommandWord())) return new DeleteCommand(args);
        return new InvalidCommand(args);

    }
}
