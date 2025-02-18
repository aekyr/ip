package laffy.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import laffy.tasklist.tasks.Task;
import laffy.tasklist.tasks.ToDo;

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
