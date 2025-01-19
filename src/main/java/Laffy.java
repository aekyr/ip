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

    public static void addTask(String task) {
        horizontalLine();
        System.out.println("added: " + task);
        horizontalLine();
    }

    public static void commandParse() {
        System.out.print("> ");
        String cmd = new Scanner(System.in).nextLine();
        switch (cmd) {
            case "bye":
                bye();
                break;
            case "list":
                echo(list.toString());
                commandParse();
                break;
            default:
                list.add(cmd);
                echo("added: " + cmd);
                commandParse();

        }
    }

    public static void main(String[] args) {
        greet();

        commandParse();
    }
}
