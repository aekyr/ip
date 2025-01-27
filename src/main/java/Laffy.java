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
        Parser parser = new Parser(taskList, storage);
        ui.greet();
        ui.chat(sc, parser);
    }

    public static void main(String[] args) throws IOException {
        new Laffy("data/laffy.txt").run();
    }
}
