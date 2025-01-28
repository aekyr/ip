package laffy.command.exceptions;

public class MissingKeywordFlag extends LaffyException {
    private static final String message = "Missing keyword flag. ";

    public MissingKeywordFlag(String explanation) {
        super(message + explanation);
    }
}
