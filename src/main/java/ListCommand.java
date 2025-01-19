public class ListCommand extends Command {

    public ListCommand(List list) {
        super(list);
    }

    @Override
    public String execute() {
        return super.list.toString();
    }


}
