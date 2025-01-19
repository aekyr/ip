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

    public static void addDeadline(String arg) {
        String[] args = arg.split(" /by ", 2);
        if (args.length < 2) {
            echo("Invalid deadline format!");
            return;
        }
        echo("Got it. I've added this task: \n  "
                + list.addDeadline(args[0], args[1]));
    }

    public static void addEvent(String arg) {
        String[] args = arg.split(" /from ", 2);
        String[] args2 = args[1].split(" /to ", 2);
        if (args2.length < 2) {
            echo("Invalid event format!");
            return;
        }
        echo("Got it. I've added this task: \n  "
                + list.addEvent(args[0], args2[0], args2[1]));
    }

    public static void chat(Scanner sc, ListCommandParser parser) {
        System.out.print("> ");
        String cmd = "";
        try {
            cmd = sc.nextLine();
        } catch (Exception e) {
            echo("Scanner could not find next line, assumed End of Test");
            return;
        }
        String[] cmdArgs = cmd.split(" ", 2);
        String keyword = cmdArgs[0];
        String args = "";
        if (cmdArgs.length == 2) {
            args = cmdArgs[1];
        }

        switch (keyword) {
            case "":
                chat(sc, parser);
                break;
            case "bye":
                bye();
                break;
            default:
                Command command = parser.parse(keyword, args);
                echo(command.execute());
                chat(sc, parser);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListCommandParser parser = new ListCommandParser(list);
        greet();

        chat(sc, parser);
    }
}
