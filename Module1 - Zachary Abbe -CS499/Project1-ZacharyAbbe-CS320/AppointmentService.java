/*******************
*Name: Zachary Abbe
*Date: 04/12/2025
*Desc: this is the service class that adds updates, and deletes appointments.
********************/

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {

    public ArrayList<Appointment> apptList = new ArrayList<Appointment>();

    // Adds a new appointment using the Appointment constructor, then assigns to the list.
    public void addAppointment(Appointment appointment) {
        // add the new appointment
        apptList.add(appointment);
    }
// finds the appt by id
    public Appointment findApptbyId(String id) {
        for (Appointment a : apptList) {
            if (a.getUniqueID().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;

    }
//deletes appt
    public void deleteAppt(String id){

        apptList.removeIf(a->a.getUniqueID().equalsIgnoreCase(id));
    }
}
