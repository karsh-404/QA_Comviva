import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest {

    @Test
    public void testAddBookToCatalog() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Hobbit", "J.R.R. Tolkien");
        catalog.addBook(book);
        List<Book> books = catalog.getBooks();
        assertEquals(1, books.size());
        assertEquals("The Hobbit", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksFromEmptyCatalog() {
        LibraryCatalog catalog = new LibraryCatalog();
        List<Book> books = catalog.getBooks();
        assertTrue(books.isEmpty());
    }

    @Test
    public void testBorrowAvailableBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        catalog.addBook(book);
        catalog.borrowBook("Harry Potter and the Philosopher's Stone");
        assertFalse(catalog.getBooks().get(0).isAvailable());
    }

    @Test
    public void testBorrowUnavailableBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis");
        catalog.addBook(book);
        catalog.borrowBook("The Lion, the Witch and the Wardrobe");
        assertFalse(catalog.getBooks().get(0).isAvailable());
        // Attempt to borrow again should not change availability
        catalog.borrowBook("The Lion, the Witch and the Wardrobe");
        assertFalse(catalog.getBooks().get(0).isAvailable());
    }

    @Test
    public void testReturnBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("Alice's Adventures in Wonderland", "Lewis Carroll");
        catalog.addBook(book);
        catalog.borrowBook("Alice's Adventures in Wonderland");
        assertFalse(catalog.getBooks().get(0).isAvailable());
        catalog.returnBook("Alice's Adventures in Wonderland");
        assertTrue(catalog.getBooks().get(0).isAvailable());
    }

    @Test
    public void testReturnUnavailableBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("Peter Pan", "J.M. Barrie");
        catalog.addBook(book);
        // Attempt to return an already available book should not change availability
        catalog.returnBook("Peter Pan");
        assertTrue(catalog.getBooks().get(0).isAvailable());
    }
}
