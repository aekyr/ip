package laffy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    String filepath;
    ArrayList<ArrayList<String>> tasksData;

    public Storage(String filepath) throws IOException {
        this.filepath = filepath;
        loadData();
    }

    private static boolean isValidType(String type) {
        return type.equals("T") || type.equals("D") || type.equals("E");
    }

    private static boolean isValidDone(String done) {
        return done.equals("0") || done.equals("1");
    }

    private static boolean isValidDesc(String desc) {
        return !desc.isBlank() && !desc.isEmpty();
    }

    private static boolean isValidBy(String by) {
        return !by.isBlank() && !by.isEmpty();
    }

    private static boolean isValidFrom(String from) {
        return !from.isBlank() && !from.isEmpty();
    }

    private static boolean isValidTo(String to) {
        return !to.isBlank() && !to.isEmpty();
    }

    private void loadData() throws IOException {

        // load data from file
        ArrayList<ArrayList<String>> tasksData = new ArrayList<>(); // [type, isDone, desc, by, from, to]
        try {
            File file = new File(this.filepath);
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
            this.tasksData = tasksData;
            return;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, creating new file");
            File file = new File(this.filepath);
            boolean mkdirSuccess = file.getParentFile().mkdirs();
            boolean fileSuccess = file.createNewFile();
        }
        this.tasksData = tasksData;
    }

    public ArrayList<ArrayList<String>> getTasksData() {
        return this.tasksData;
    }

    public void saveData(ArrayList<ArrayList<String>> tasksData) {
        try {
            File file = new File(this.filepath);
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
}
