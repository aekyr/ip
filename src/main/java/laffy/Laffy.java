package laffy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import laffy.command.Command;
import laffy.tasklist.TaskList;


/**
 * Represents the main class of the application.
 */
public class Laffy {
    private final TaskList taskList;
    private final Storage storage;
    private final Ui ui;

    /**
     * Constructor for Laffy.
     *
     * @param filepath The file path to the data file.
     * @throws IOException If an I/O error occurs.
     */
    public Laffy(String filepath) throws IOException {
        this.storage = new Storage(filepath);
        this.ui = new Ui();
        ArrayList<ArrayList<String>> loadedData = this.storage.getTasksData();
        if (loadedData.isEmpty()) {
            this.taskList = new TaskList();
        } else {
            this.taskList = new TaskList(loadedData);
        }
    }

    /**
     * Runs the Laffy program.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            System.out.print("> ");
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main method for Laffy. No args are expected.
     *
     * @param args The command line arguments.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        new Laffy("data/laffy.txt").run();
    }

    public String getResponse(String input) {
        return "Response: " + input;
    }
}
