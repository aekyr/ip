package laffy;

import laffy.command.Command;
import laffy.tasklist.TaskList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Laffy {
    private final TaskList taskList;
    private final Storage storage;
    private final Ui ui;

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
                ui.echo(c.execute(taskList, ui, storage));
                isExit = c.isExit();
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Laffy("data/laffy.txt").run();
    }
}
