package laffy.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import laffy.tasklist.tasks.Task;
import laffy.tasklist.tasks.ToDo;
import org.junit.jupiter.api.Test;

public class TaskListTest {
    @Test
    public void taskList_emptyTaskList_emptyTaskList() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.size());
    }

    @Test
    public void taskList_addTask_taskListWithTask() {
        TaskList taskList = new TaskList();
        Task task = new ToDo("task desc");
        taskList.addTodo("task desc");
        assertEquals(1, taskList.size());
    }


}
