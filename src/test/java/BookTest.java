import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookInitialization() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testSetAvailable() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee");

        // Initially available
        assertTrue(book.isAvailable());

        // Set to unavailable
        book.setAvailable(false);
        assertFalse(book.isAvailable());

        // Set back to available
        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }

    // Additional tests can be added to cover more scenarios as needed.
}