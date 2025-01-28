package laffy.command.exceptions;

public class InvalidIndex extends LaffyException {
    private static final String message = "Invalid index. ";

    public InvalidIndex(String explanation) {
        super(message + explanation);
    }
}
