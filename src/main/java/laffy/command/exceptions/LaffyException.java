package laffy.command.exceptions;

public class LaffyException extends Exception {
    public LaffyException(String message) {
        super("[PARSE-ERROR]: " + message + "\n");
    }
}
