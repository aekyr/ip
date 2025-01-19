import java.util.Scanner;

public class Laffy {

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

    public static void main(String[] args) {
        greet();
        while (true) {
            System.out.print("> ");
            String input = new Scanner(System.in).nextLine();
            if (input.equals("bye")) {
                break;
            } else {
                echo(input);
            }
        }
        bye();
    }
}
