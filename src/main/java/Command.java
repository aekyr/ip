abstract class Command {
    protected List list;
    protected boolean isValid;
    public static final String COMMAND_WORD = "command";

    public Command (List list) {
        this.list = list;
        this.isValid = false;
    }
    public abstract String execute();

    public static String getDescription() {
        return "";
    }

    public static String getUsage() {
        return "Usage: " ;
    }
}
