import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact c;

    @BeforeEach
    void setUp() {
        c = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", c.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", c.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        c = new Contact("Grace Hopper", "555-0000");
        assertEquals("Grace Hopper", c.getName());
    }

    @Test
    void toString_containsName() {
        c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("555-0001"));
    }

    @Test
    void contacts_withSameName_haveIndependentPhoneNumbers() {
        Contact contact1 = new Contact("John Smith", "555-1111");
        Contact contact2 = new Contact("John Smith", "555-2222");

        assertEquals("John Smith", contact1.getName());
        assertEquals("John Smith", contact2.getName());
        assertEquals("555-1111", contact1.getPhone());
        assertEquals("555-2222", contact2.getPhone());
    }
}