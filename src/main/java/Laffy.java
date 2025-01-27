import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Laffy {
    static TaskList taskList = new TaskList();

    public static boolean isValidType(String type) {
        return type.equals("T") || type.equals("D") || type.equals("E");
    }

    public static boolean isValidDone(String done) {
        return done.equals("0") || done.equals("1");
    }

    public static boolean isValidDesc(String desc) {
        return !desc.isBlank() && !desc.isEmpty();
    }

    public static boolean isValidBy(String by) {
        return !by.isBlank() && !by.isEmpty();
    }

    public static boolean isValidFrom(String from) {
        return !from.isBlank() && !from.isEmpty();
    }

    public static boolean isValidTo(String to) {
        return !to.isBlank() && !to.isEmpty();
    }

    public static ArrayList<ArrayList<String>> loadData() throws FileNotFoundException, IOException {

        // load data from file
        ArrayList<ArrayList<String>> tasksData = new ArrayList<>(); // [type, isDone, desc, by, from, to]
        try {
            File file = new File("data/laffy.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] task = line.split(" \\| ");
                String type = task[0];
                String isDone = task[1];
                String desc = task[2];
                ArrayList<String> taskData = new ArrayList<>();
                if (isValidType(type) && isValidDone(isDone) && isValidDesc(desc)) {
                    taskData.add(type);
                    taskData.add(isDone);
                    taskData.add(desc);
                    if (type.equals("T")) {
                        if (task.length == 3) {
                            tasksData.add(taskData);
                        }
                    } else if (type.equals("D")) {
                        if (task.length == 4) {
                            String by = task[3];
                            if (isValidBy(by)) {
                                taskData.add(by);
                                tasksData.add(taskData);
                            }
                        }
                    } else if (type.equals("E")) {
                        if (task.length == 5) {
                            String from = task[3];
                            String to = task[4];
                            if (isValidFrom(from) && isValidTo(to)) {
                                taskData.add(from);
                                taskData.add(to);
                                tasksData.add(taskData);
                            }
                        }
                    }
                }
            }
            sc.close();
            return tasksData;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, creating new file");
            File file = new File("data/laffy.txt");
            boolean mkdirSuccess = file.getParentFile().mkdirs();
            boolean fileSuccess = file.createNewFile();
        }
        return tasksData;
    }

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
