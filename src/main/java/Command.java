abstract class Command {
    protected List list;
    protected boolean isValid;

    public Command (List list) {
        this.list = list;
        this.isValid = false;
    }
    public abstract String execute();
}
