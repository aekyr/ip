package laffy.tasklist.exceptions;

public class TasklistException extends Exception {
    private static final String message = "[TASKL-ERROR]: An error occurred while executing the command.\n";

    public TasklistException(String explanation) {
        super(message + explanation);
    }
}
