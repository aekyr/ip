import TaskList.TaskList;

import java.util.Scanner;

public class Laffy {
    static TaskList taskList = new TaskList();

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
        ListCommandParser parser = new ListCommandParser(taskList);
        greet();

        chat(sc, parser);
    }
}
