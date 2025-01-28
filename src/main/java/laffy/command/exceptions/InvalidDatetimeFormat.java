package laffy.command.exceptions;

public class InvalidDatetimeFormat extends LaffyException {
    private static final String message = "Invalid datetime format.\nExpected: dd-MM-yy [HHmm].\nInstead got: ";

    public InvalidDatetimeFormat(String explanation) {
        super(message + explanation);
    }
}
