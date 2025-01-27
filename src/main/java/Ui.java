import java.util.Scanner;

public class Ui {
    private void horizontalLine() {
        System.out.println("____________________________________________________________");
    }

    public void greet() {
        horizontalLine();
        System.out.println("Hello! I'm L.A.F.F.Y");
        System.out.println("What can I do for you?");
        horizontalLine();
    }

    public void bye() {
        horizontalLine();
        System.out.println("Bye. Hope to see you again soon!");
        horizontalLine();
    }

    public void echo(String input) {
        horizontalLine();
        System.out.println(input);
        horizontalLine();
    }

    public void chat(Scanner sc, Parser parser) {
        System.out.print("> ");
        String cmd = sc.nextLine();
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
}
