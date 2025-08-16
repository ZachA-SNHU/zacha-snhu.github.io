/********************
 * Name: Zachary Abbe
 * Course: CS-320
 * Date: 04/17/2025
 * Desc: This contact class contains all the variables necessary for creating a contact
 ********************/




public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Constructor
    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setters with Validation
    public void setId(String id) {
        if (id == null || id.trim().isEmpty() || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid FirstName");
        }
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid LastName");
        }
        this.lastName = lastName.trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid Phone Number - must be exactly 10 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address.trim();
    }
}
