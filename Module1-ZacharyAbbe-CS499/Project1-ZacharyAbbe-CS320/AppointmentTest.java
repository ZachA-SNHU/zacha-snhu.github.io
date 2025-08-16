



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;



class AppointmentTest {

    // function to get a guaranteed future date
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1); // 1 day ahead
        return calendar.getTime();
    }

    // fucntion to get a past date
    private Date getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    @DisplayName("Valid constructor creates correct Appointment")
    @Test
    void testValidAppointment() {
        String id = "001";
        Date goodDate = getFutureDate();
        String description = "This shall be the very best description possible!!";

        Appointment tempAppt = new Appointment(id, goodDate, description);

        assertEquals("001", tempAppt.getUniqueID());
        assertEquals(goodDate, tempAppt.getDate());
        assertEquals(description, tempAppt.getDescription());
    }

    @DisplayName("Reject ID that is too long")
    @Test
    void testLongID() {
        String id = "123456789101112";
        Date goodDate = getFutureDate();
        String description = "Valid description";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, description);
        });
        assertEquals("Invalid ID", exception.getMessage());
    }

    @DisplayName("Reject null ID")
    @Test
    void testNullID() {
        Date goodDate = getFutureDate();
        String description = "Valid description";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, goodDate, description);
        });
        assertEquals("Invalid ID", exception.getMessage());
    }

    @DisplayName("Reject past date")
    @Test
    void testPastDate() {
        String id = "1";
        Date badDate = getPastDate();
        String description = "Valid description";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, badDate, description);
        });
        assertEquals("Invalid date", exception.getMessage());
    }

    @DisplayName("Reject null date")
    @Test
    void testNullDate() {
        String id = "1";
        Date goodDate = getFutureDate();
        String description = "Valid description";

        Appointment tempAppt = new Appointment(id, goodDate, description);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            tempAppt.setDate(null);
        });
        assertEquals("Invalid date", exception.getMessage());
    }

    @DisplayName("Reject description that is too long")
    @Test
    void testLongDescription() {
        String id = "1";
        Date goodDate = getFutureDate();
        String longDesc = "A".repeat(51); // 51 characters

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, longDesc);
        });
        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Reject null description")
    @Test
    void testNullDescription() {
        String id = "1";
        Date goodDate = getFutureDate();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, null);
        });
        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Reject empty description")
    @Test
    void testEmptyDescription() {
        String id = "1";
        Date goodDate = getFutureDate();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, goodDate, "");
        });
        assertEquals("Invalid description", exception.getMessage());
    }

    @DisplayName("Accept max length ID and description")
    @Test
    void testMaxLengthFields() {
        String id = "1234567890"; // 10 characters
        String desc = "A".repeat(50); // 50 characters
        Date goodDate = getFutureDate();

        Appointment appt = new Appointment(id, goodDate, desc);
        assertEquals(id, appt.getUniqueID());
        assertEquals(desc, appt.getDescription());
    }
}
