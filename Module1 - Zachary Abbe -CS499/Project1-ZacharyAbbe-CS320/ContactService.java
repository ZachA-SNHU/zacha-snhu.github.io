/********************
 * Name: Zachary Abbe
 * Course: CS-320
 * Date: 04/12/2025
 * Desc: This contactService class contains the necessary capabilities of creating a list of contacts, while adding new ones and deleting them, as well as updates.
 ********************/
import java.util.ArrayList;

public class ContactService {

    // List to store contacts
    private final ArrayList<Contact> contacts = new ArrayList<>();

    // Adds a new contact if the ID is unique
    public boolean addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getId().equalsIgnoreCase(contact.getId())) {
                throw new IllegalArgumentException("Duplicate ID");
            }
        }
        contacts.add(contact);
        return true;
    }

    // Deletes a contact by ID
    public void deleteContact(String id) {
        contacts.removeIf(c -> c.getId().equalsIgnoreCase(id));
    }

    // Updates the first name of a contact by ID
    public void updateFirstName(String id, String firstName) {
        Contact contact = findContactById(id);
        if (contact != null) {
            contact.setFirstName(firstName);
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    // Updates the last name of a contact by ID
    public void updateLastName(String id, String lastName) {
        Contact contact = findContactById(id);
        if (contact != null) {
            contact.setLastName(lastName);
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    // Updates the phone number of a contact by ID
    public void updatePhoneNumber(String id, String phoneNumber) {
        Contact contact = findContactById(id);
        if (contact != null) {
            contact.setPhoneNumber(phoneNumber);
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    // Updates the address of a contact by ID
    public void updateAddress(String id, String address) {
        Contact contact = findContactById(id);
        if (contact != null) {
            contact.setAddress(address);
        } else {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    // Helper method to find a contact by ID
    private Contact findContactById(String id) {
        for (Contact c : contacts) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Getter for test access
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}

