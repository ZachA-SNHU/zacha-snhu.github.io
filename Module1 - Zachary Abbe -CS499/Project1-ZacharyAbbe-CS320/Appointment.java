/***************
 * Name: Zachary Abbe
 * Date: 04/12/2025
 * Desc: This is the Appointment Class that houses all the variables for the object
 **************/
import java.util.Date;

public class Appointment {

    private String uniqId;
    private Date date;
    private String description;


     // validates the uniqueID

    private final boolean validateID(String uniqueID) {
        if(uniqueID == null || uniqueID.length() > 10) {
            return false;
        }
        return true;
    }


     // validates the Name

    private final boolean validateDate(Date _date) {

        if(_date == null || _date.before(new Date())) {
            return false;
        }
        return true;
    }

     //validates the description

    private final boolean validateDescription(String description) {
        if(description == null || description.length() > 50 || description.equals("")) {
            return false;
        }
        return true;
    }

    // constructor for the object
    public Appointment(String uniqueID,
                       Date date,
                       String description) {

        if(!this.validateID(uniqueID)) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if(!this.validateDate(date)) {
            throw new IllegalArgumentException("Invalid date");
        }

        if(!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }


        setID(uniqueID);
        setDate(date);
        setDescription(description);

    }
    //getters and setters
    public String getUniqueID() {
        return uniqId;
    }


    private void setID(String uniqueID){
        this.uniqId = uniqueID;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if(!this.validateDate(date)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
