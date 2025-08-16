import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    @DisplayName("Adding a task successfully")
    void testAddTask() {
        Task task = new Task("123", "Test Task", "This is a test description.");
        taskService.addTask(task);
        Task result = taskService.findTaskbyId("123");

        assertNotNull(result, "Task should exist after being added.");
        assertEquals("123", result.getUniqId());
        assertEquals("Test Task", result.getFullName());
        assertEquals("This is a test description.", result.getDesc());
    }

    @Test
    @DisplayName("Adding a duplicate task should return false")
    void testAddDuplicateTask() {
        Task task1 = new Task("123", "Test Task", "This is a test description.");
        Task task2 = new Task("123", "Another Task", "Another Description");

        boolean addedFirst = taskService.addTask(task1);
        boolean addedDuplicate = taskService.addTask(task2);

        assertTrue(addedFirst, "The first task should be added successfully.");
        assertFalse(addedDuplicate, "Duplicate task should not be added.");
    }


    @Test
    @DisplayName("Finding an existing task by ID")
    void testFindTaskById() {
        Task task = new Task("123", "Find Me", "Find this task.");
        taskService.addTask(task);

        Task foundTask = taskService.findTaskbyId("123");

        assertNotNull(foundTask);
        assertEquals("Find Me", foundTask.getFullName());
    }

    @Test
    @DisplayName("Finding a non-existent task should return null")
    void testFindNonExistentTask() {
        assertNull(taskService.findTaskbyId("999"), "Task should not exist.");
    }

    @Test
    @DisplayName("Deleting a task should remove it from the list")
    void testDeleteTask() {
        Task task = new Task("123", "Delete Me", "This task will be deleted.");
        taskService.addTask(task);
        taskService.deleteTask("123");

        assertNull(taskService.findTaskbyId("123"), "Task should be deleted.");
    }

    @Test
    @DisplayName("Updating a task name should change its name")
    void testUpdateTaskName() {
        Task task = new Task("123", "Old Name", "Description remains.");
        taskService.addTask(task);
        taskService.updateName("123", "New Name");

        Task updatedTask = taskService.findTaskbyId("123");
        assertNotNull(updatedTask);
        assertEquals("New Name", updatedTask.getFullName());
    }

    @Test
    @DisplayName("Updating a task name for a non-existent task should throw an exception")
    void testUpdateTaskNameForNonExistentTask() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateName("999", "New Name");
        });

        assertEquals("Task not found - can't update name", exception.getMessage());
    }

    @Test
    @DisplayName("Updating a task description should change its description")
    void testUpdateTaskDesc() {
        Task task = new Task("123", "Task Name", "Old Description");
        taskService.addTask(task);
        taskService.updateDesc("123", "New Description");

        Task updatedTask = taskService.findTaskbyId("123");
        assertNotNull(updatedTask);
        assertEquals("New Description", updatedTask.getDesc());
    }

    @Test
    @DisplayName("Updating a task description for a non-existent task should throw an exception")
    void testUpdateTaskDescForNonExistentTask() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateDesc("999", "New Description");
        });

        assertEquals("Task not found - can't update the description", exception.getMessage());
    }

    @Test
    @DisplayName("Task list should be empty initially")
    void testTaskListInitiallyEmpty() {
        List<Task> tasks = taskService.getTaskList();
        assertTrue(tasks.isEmpty(), "Task list should start empty.");
    }
}
