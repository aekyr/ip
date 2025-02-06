package laffy.tasklist.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void task_desc_taskWithDesc() {
        Task task = new Task("task desc");
        assertEquals("task desc", task.getDescription());
    }

    @Test
    public void task_descAndIsDone_taskWithDescAndIsDone() {
        Task task = new Task("task desc", true);
        assertEquals("task desc", task.getDescription());
        assertTrue(task.isDone());

        Task task2 = new Task("task desc", false);
        assertEquals("task desc", task2.getDescription());
        assertFalse(task2.isDone());
    }

    @Test
    public void markAsDone_task_taskIsDone() {
        Task task = new Task("task desc");
        assertFalse(task.isDone());
        task.markAsDone();
        assertTrue(task.isDone());
    }

    @Test
    public void markAsUndone_task_taskIsUndone() {
        Task task = new Task("task desc", true);
        assertTrue(task.isDone());
        task.markAsUndone();
        assertFalse(task.isDone());
    }

    @Test
    public void toString_task_taskString() {
        Task task = new Task("task desc");
        assertEquals("[ ] task desc", task.toString());

        Task task2 = new Task("task desc", true);
        assertEquals("[X] task desc", task2.toString());
    }

    @Test
    public void toTaskData_task_taskData() {
        Task task = new Task("task desc");
        ArrayList<String> taskData = task.toTaskData();
        assertEquals("I", taskData.get(0));
        assertEquals("0", taskData.get(1));
        assertEquals("task desc", taskData.get(2));

        Task task2 = new Task("task desc", true);
        ArrayList<String> taskData2 = task2.toTaskData();
        assertEquals("I", taskData2.get(0));
        assertEquals("1", taskData2.get(1));
        assertEquals("task desc", taskData2.get(2));
    }

}
