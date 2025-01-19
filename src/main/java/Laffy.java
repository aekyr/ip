import java.util.Scanner;

public class Laffy {
    static List list = new List();

    public static void horizontalLine() {
        System.out.println("____________________________________________________________");
    }

    public static void greet() {
        horizontalLine();
        System.out.println("Hello! I'm L.A.F.F.Y");
        System.out.println("What can I do for you?");
        horizontalLine();
    }

    public static void bye() {
        horizontalLine();
        System.out.println("Bye. Hope to see you again soon!");
        horizontalLine();
    }

    public static void echo(String input) {
        horizontalLine();
        System.out.println(input);
        horizontalLine();
    }

    public static boolean markArgIsValid(String arg) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return false;
        }
        return list.isValidIndex(Integer.parseInt(arg) - 1);
    }

    public static void markAsDone(String arg) {
        if (!markArgIsValid(arg)) {
            echo("Usage: mark <index>");
            return;
        }
        int markIndex = Integer.parseInt(arg) - 1;
        if (list.get(markIndex).isDone()) {
            echo("Task is already marked as done!");
        } else {
            list.markAsDone(markIndex);
            echo("Nice! I've marked this task as done: \n  "
                    + list.get(markIndex).toString());
        }
    }

    public static void unmarkAsDone(String arg) {
        if (!markArgIsValid(arg)) {
            echo("Invalid index!");
            return;
        }
        int markIndex = Integer.parseInt(arg) - 1;
        if (!list.get(markIndex).isDone()) {
            echo("Task is already marked as not done!");
        } else {
            list.markAsUndone(markIndex);
            echo("Ok, I've marked this task as not yet done: \n  "
                    + list.get(markIndex).toString());
        }
    }

    public static void addTodo(String arg) {
        ToDo todo = list.addTodo(arg);
        echo("Got it. I've added this task: \n  "
                + todo.toString());
    }

    public static void addDeadline(String arg) {
        String[] args = arg.split(" /by ", 2);
        if (args.length < 2) {
            echo("Invalid deadline format!");
            return;
        }

        Deadline deadline = list.addDeadline(args[0], args[1]);
        echo("Got it. I've added this task: \n  "
                + deadline.toString());
    }

    public static void addEvent(String arg) {
        String[] args = arg.split(" /from ", 2);
        String[] args2 = args[1].split(" /to ", 2);
        if (args2.length < 2) {
            echo("Invalid event format!");
            return;
        }

        Event event = list.addEvent(args[0], args2[0], args2[1]);
        echo("Got it. I've added this task: \n  "
                + event.toString());
    }

    public static void commandParse() {
        System.out.print("> ");
        String cmd = new Scanner(System.in).nextLine();
        String[] cmdArgs = cmd.split(" ", 2);
        String keyword = cmdArgs[0];
        String arg = "";
        if (cmdArgs.length > 1) {
            arg = cmdArgs[1];
        }
        switch (keyword) {
            case "":
                commandParse();
                break;
            case "bye":
                bye();
                break;
            case "list":
                echo(list.toString());
                commandParse();
                break;
            case "mark":
                markAsDone(arg);
                commandParse();
                break;
            case "unmark":
                unmarkAsDone(arg);
                commandParse();
                break;
            case "todo":
                addTodo(arg);
                commandParse();
                break;
            case "deadline":
                addDeadline(arg);
                commandParse();
                break;
            case "event":
                addEvent(arg);
                commandParse();
                break;
            default:
                echo("I'm sorry, but I don't know what that means");
                commandParse();

        }
    }

    public static void main(String[] args) {
        greet();

        commandParse();
    }
}
