import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    @DisplayName("Task ID cannot have more than 10 characters")
    void testTaskIDWithMoreThanTenCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Valid Name", "Valid Description");
        });
        assertEquals("Invalid ID", exception.getMessage());
    }

    @Test
    @DisplayName("Task Name cannot have more than 20 characters")
    void testTaskNameWithMoreThanTwentyCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "This is a very long task name exceeding limit", "Valid Description");
        });
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testTaskDescWithMoreThanFiftyCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Valid Name", "This is a very long description that definitely exceeds the 50-character limit.");
        });
        assertEquals("Invalid desc", exception.getMessage());
    }

    @Test
    @DisplayName("Task Name shall not be null")
    void testTaskNameNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Valid Description");
        });
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    @DisplayName("Task Description shall not be null")
    void testTaskDescNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Valid Name", null);
        });
        assertEquals("Invalid desc", exception.getMessage());
    }

    @Test
    @DisplayName("Valid Task should be created successfully")
    void testValidTaskCreation() {
        Task task = new Task("1234567890", "Valid Name", "Valid Description");
        assertEquals("1234567890", task.getUniqId());
        assertEquals("Valid Name", task.getFullName());
        assertEquals("Valid Description", task.getDesc());
    }
}
