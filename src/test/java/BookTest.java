import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testDocumentaryCreation() {
        Book documentary = new Book("Planet Earth II", "BBC Studios");
        assertEquals("Planet Earth II", documentary.getTitle());
        assertEquals("BBC Studios", documentary.getAuthor());
        assertTrue(documentary.isAvailable());
    }

    @Test
    public void testDocumentaryAvailabilityAfterCheckout() {
        Book documentary = new Book("The Act of Killing", "Joshua Oppenheimer");
        assertTrue(documentary.isAvailable());
        documentary.setAvailable(false);
        assertFalse(documentary.isAvailable());
    }

    @Test
    public void testDocumentaryAvailabilityAfterCheckin() {
        Book documentary = new Book("An Inconvenient Truth", "Davis Guggenheim");
        documentary.setAvailable(false);
        assertFalse(documentary.isAvailable());
        documentary.setAvailable(true);
        assertTrue(documentary.isAvailable());
    }

    @Test
    public void testDocumentaryTitleWithSpecialCharacters() {
        Book documentary = new Book("The Cove", "Louie Psihoyos");
        assertEquals("The Cove", documentary.getTitle());
    }

    @Test
    public void testDocumentaryAuthorWithNumbers() {
        Book documentary = new Book("Super Size Me", "Morgan Spurlock");
        assertEquals("Morgan Spurlock", documentary.getAuthor());
    }

    @Test
    public void testDocumentaryWithEmptyTitleAndAuthor() {
        Book documentary = new Book("", "");
        assertEquals("", documentary.getTitle());
        assertEquals("", documentary.getAuthor());
        assertTrue(documentary.isAvailable());
    }

    @Test
    public void testDocumentaryWithLongTitleAndAuthor() {
        Book documentary = new Book("The Vietnam War: A Film by Ken Burns and Lynn Novick", "Ken Burns");
        assertEquals("The Vietnam War: A Film by Ken Burns and Lynn Novick", documentary.getTitle());
        assertEquals("Ken Burns", documentary.getAuthor());
        assertTrue(documentary.isAvailable());
    }

    @Test
    public void testDocumentaryWithNullTitleAndAuthor() {
        Book documentary = new Book(null, null);
        assertNull(documentary.getTitle());
        assertNull(documentary.getAuthor());
        assertTrue(documentary.isAvailable());
    }
}
