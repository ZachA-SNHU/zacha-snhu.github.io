import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        Contact initialContact = new Contact("1", "Junie", "B Jones", "1234567890", "123 Elm St");
        contactService.addContact(initialContact);
    }

    @Test
    @DisplayName("Testing first name update")
    @Order(1)
    void testFirstNameUpdate() {
        contactService.updateFirstName("1", "Maxwell");
        assertEquals("Maxwell", contactService.getContacts().get(0).getFirstName());
    }

    @Test
    @DisplayName("Testing last name update")
    @Order(2)
    void testLastNameUpdate() {
        contactService.updateLastName("1", "Brown");
        assertEquals("Brown", contactService.getContacts().get(0).getLastName());
    }

    @Test
    @DisplayName("Testing phone number update")
    @Order(3)
    void testPhoneNumberUpdate() {
        contactService.updatePhoneNumber("1", "5555555555");
        assertEquals("5555555555", contactService.getContacts().get(0).getPhoneNumber());
    }

    @Test
    @DisplayName("Testing address update")
    @Order(4)
    void testAddressUpdate() {
        contactService.updateAddress("1", "100 Main Street");
        assertEquals("100 Main Street", contactService.getContacts().get(0).getAddress());
    }

    @Test
    @DisplayName("Testing delete")
    @Order(5)
    void testDelete() {
        contactService.deleteContact("1");
        assertEquals(0, contactService.getContacts().size());
    }

    @Test
    @DisplayName("Testing add")
    @Order(6)
    void testAdd() {
        Contact newContact = new Contact("2", "John", "Doe", "9876543210", "456 Oak St");
        contactService.addContact(newContact);
        assertEquals(2, contactService.getContacts().size());
    }

    @Test
    @DisplayName("Testing duplicate ID")
    @Order(7)
    void testDuplicateId() {
        Contact duplicate = new Contact("1", "NewName", "NewLast", "1234567890", "New Address");
        assertThrows(IllegalArgumentException.class, () ->
                contactService.addContact(duplicate)
        );
    }

    @Test
    @DisplayName("Testing updating non-existent contact")
    @Order(8)
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateFirstName("99", "DoesNotExist")
        );
    }
}
