package laffy.command;

import laffy.Storage;
import laffy.tasklist.TaskList;
import laffy.Ui;

public class InvalidCommand extends Command {
    public static final String COMMAND_WORD = "invalid";

    public InvalidCommand(String args) {
        super(args);
        this.isValid = true;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append(InvalidCommand.getDescription());
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
        sb.append("\n8. ");
        sb.append(ExitCommand.getDescription());
        ui.echo(sb.toString());
    }

    public static String getDescription() {
        return "Invalid command. Please enter a valid command.";
    }

    public String getUsage() {
        return "";
    }
}
