package laffy;

import java.util.Scanner;

/**
 * Represents the User Interface of the application.
 */
public class Ui {
    private final Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Greets the user.
     */
    public void greet() {
        showLine();
        System.out.println("Hello! I'm L.A.F.F.Y");
        System.out.println("What can I do for you?");
        showLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void echo(String input) {
        System.out.println(input);
    }
}
