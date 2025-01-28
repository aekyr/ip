package laffy.command.exceptions;

public class TooManyArguments extends LaffyException {
    private static final String message = "Too many arguments. ";

    public TooManyArguments(String explanation) {
        super(message + explanation);
    }
}
