package laffy.command;

import laffy.Storage;
import laffy.command.exceptions.MissingKeywordFlag;
import laffy.tasklist.TaskList;
import laffy.Ui;
import laffy.tasklist.exceptions.TasklistException;

public abstract class Command {
    private boolean isValid;
    private static final String COMMAND_WORD = "command";

    public Command (String args) {
        this.isValid = false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws TasklistException {
        // executes after all children have done so
        storage.saveData(taskList.toTasksData());
    };

    public boolean isExit() {
        return false;
    }

    public void checkKeywordFlagIsPresent(String args, String keywordFlag) throws MissingKeywordFlag {
        if (!args.matches(keywordFlag + "|(.*)\\s" + keywordFlag + "|" + keywordFlag + "\\s(.*)|(.*)\\s" + keywordFlag + "\\s(.*)")) {
            throw new MissingKeywordFlag("Could not find flag \"" + keywordFlag + "\" in command.\n" + getUsage());
        }
    }

    public boolean matchesCommandWord(String word) {
        return word.equals(COMMAND_WORD);
    }

    public static String getCommandWord() {
        return COMMAND_WORD;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean bool) {
        this.isValid = bool;
    }

    public static String getDescription() {
        return "";
    }

    public String getUsage() {
        return "Usage: " ;
    }

}
