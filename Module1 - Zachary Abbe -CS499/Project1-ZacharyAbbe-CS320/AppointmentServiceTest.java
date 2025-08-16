import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {

    private AppointmentService service;
    private Date futureDate;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        futureDate = calendar.getTime();
    }
    @DisplayName("Creates correct Appointment")
    @Test
    public void testAddAppointment() {
        Appointment appt = new Appointment("001", futureDate, "Dentist appointment");
        service.addAppointment(appt);

        Appointment found = service.findApptbyId("001");
        assertNotNull(found);
        assertEquals("001", found.getUniqueID());
        assertEquals("Dentist appointment", found.getDescription());
    }
    @DisplayName("Deletes the correct Appointment")
    @Test
    public void testDeleteAppointment() {
        Appointment appt = new Appointment("002", futureDate, "Checkup");
        service.addAppointment(appt);

        assertNotNull(service.findApptbyId("002"));
        service.deleteAppt("002");
        assertNull(service.findApptbyId("002"));
    }
    @DisplayName("Searches for the appt by id that doesn't exist and returns null")
    @Test
    public void testFindNonExistentAppointmentReturnsNull() {
        assertNull(service.findApptbyId("nonexistent"));
    }
    @DisplayName("Checks multiple appts and ensures validity")
    @Test
    public void testMultipleAppointments() {
        Appointment appt1 = new Appointment("101", futureDate, "Appt 1");
        Appointment appt2 = new Appointment("102", futureDate, "Appt 2");

        service.addAppointment(appt1);
        service.addAppointment(appt2);

        assertNotNull(service.findApptbyId("101"));
        assertNotNull(service.findApptbyId("102"));

        service.deleteAppt("101");

        assertNull(service.findApptbyId("101"));
        assertNotNull(service.findApptbyId("102"));
    }
}
