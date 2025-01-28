package laffy.tasklist.exceptions;

public class IndexOutOfRange extends TaskListException {
    private static final String message = "Index out of range. ";

    public IndexOutOfRange(String explanation) {
        super(message + explanation);
    }
}
