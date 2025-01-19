public class UnmarkCommand extends MarkCommand {

    public UnmarkCommand(List list, String args) {
        super(list, args);
    }

    @Override
    public String execute() {
        if (!isValid) {
            return "Index must be an integer.\nUsage: mark <index>";
        } else {
            return super.list.markAsUndone(this.index);
        }
    }
}
