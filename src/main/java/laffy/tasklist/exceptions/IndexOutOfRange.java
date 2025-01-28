package laffy.tasklist.exceptions;

public class IndexOutOfRange extends TasklistException {
    private static final String message = "Index out of range. ";

    public IndexOutOfRange(String explanation) {
        super(message + explanation);
    }
}
