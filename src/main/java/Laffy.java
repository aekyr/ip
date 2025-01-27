import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Laffy {
    private final TaskList taskList;
    private final String filepath;

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

    public static ArrayList<ArrayList<String>> loadData(String filepath) throws IOException {

        // load data from file
        ArrayList<ArrayList<String>> tasksData = new ArrayList<>(); // [type, isDone, desc, by, from, to]
        try {
            File file = new File(filepath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isBlank() || line.isEmpty()) {
                    break;
                }
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
            File file = new File(filepath);
            boolean mkdirSuccess = file.getParentFile().mkdirs();
            boolean fileSuccess = file.createNewFile();
        }
        return tasksData;
    }

    public static void saveData(String filepath, ArrayList<ArrayList<String>> tasksData) {
        try {
            File file = new File(filepath);
            FileWriter fileWriter = new FileWriter(file);
            for (ArrayList<String> taskData : tasksData) {
                String line = String.join(" | ", taskData);
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

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

    public void chat(Scanner sc, ListCommandParser parser) {
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
                saveData(this.filepath, this.taskList.toTasksData());
                chat(sc, parser);

        }
    }

    public Laffy(String filepath) throws IOException {
        this.filepath = filepath;
        ArrayList<ArrayList<String>> loadedData = loadData(filepath);
        if (loadedData.isEmpty()) {
            this.taskList = new TaskList();
        } else {
            this.taskList = new TaskList(loadedData);
        };
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        ListCommandParser parser = new ListCommandParser(taskList);
        greet();

        chat(sc, parser);

    }

    public static void main(String[] args) throws IOException {
        new Laffy("data/laffy.txt").run();
    }
}
