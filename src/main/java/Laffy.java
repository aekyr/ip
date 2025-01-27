import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Laffy {
    private final TaskList taskList;
    private final Storage storage;


    public void horizontalLine() {
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
                this.storage.saveData(this.taskList.toTasksData());
                chat(sc, parser);

        }
    }

    public Laffy(String filepath) throws IOException {
        this.storage = new Storage(filepath);
        ArrayList<ArrayList<String>> loadedData = this.storage.getTasksData();
        if (loadedData.isEmpty()) {
            this.taskList = new TaskList();
        } else {
            this.taskList = new TaskList(loadedData);
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser(taskList);
        greet();
        chat(sc, parser);
    }

    public static void main(String[] args) throws IOException {
        new Laffy("data/laffy.txt").run();
    }
}
