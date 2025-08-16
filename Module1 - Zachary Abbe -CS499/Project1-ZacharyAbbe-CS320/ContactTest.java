import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactTest {

    @Test
    @DisplayName("Contact ID cannot have more than 10 characters")
    void testIDWithMoreThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "FirstName", "LastName", "1234567890", "Address"));
    }

    @Test
    @DisplayName("Contact First Name cannot have more than 10 characters")
    void testFirstNameWithMoreThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "VeryLongFirstName", "LastName", "1234567890", "Address"));
    }

    @Test
    @DisplayName("Contact Last Name cannot have more than 10 characters")
    void testLastNameWithMoreThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "FirstName", "VeryLongLastName", "1234567890", "Address"));
    }

    @Test
    @DisplayName("Contact phone number must be exactly 10 digits")
    void testPhoneNumberNotExactlyTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "FirstName", "LastName", "12345678901", "Address")); // 11 digits
    }

    @Test
    @DisplayName("Contact address cannot have more than 30 characters")
    void testAddressWithMoreThanThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "FirstName", "LastName", "1234567890", "1234567890123456789012345678901")); // 31 chars
    }

    @Test
    @DisplayName("Contact First Name shall not be null")
    void testFirstNameNotNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", null, "LastName", "1234567890", "Address"));
    }

    @Test
    @DisplayName("Contact Last Name shall not be null")
    void testContactLastNameNotNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "FirstName", null, "1234567890", "Address"));
    }

    @Test
    @DisplayName("Contact Phone Number shall not be null")
    void testPhoneNotNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("3", "FirstName", "LastName", null, "Address"));
    }

    @Test
    @DisplayName("Contact Address shall not be null")
    void testAddressNotNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("9", "FirstName", "LastName", "1234567890", null));
    }

    @Test
    @DisplayName("Valid Contact should be created without exceptions")
    void testValidContact() {
        assertDoesNotThrow(() ->
                new Contact("9", "John", "Doe", "1234567890", "123 Elm St"));
    }
}
