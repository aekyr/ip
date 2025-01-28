package laffy.command.exceptions;

public class BlankArgument extends LaffyException {
    private static final String message = "Missing argument. ";

    public BlankArgument(String explanation) {
        super(message + explanation);
    }
}
