import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest{

    @Test
    public void testAddBookAndGetBooks() {
        LibraryCatalog library = new LibraryCatalog();
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("1984", "George Orwell");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Check if getBooks returns the correct list
        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testBorrowBook() {
        LibraryCatalog library = new LibraryCatalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book);

        // Initially available
        assertTrue(book.isAvailable());

        // Borrow the book
        library.borrowBook("To Kill a Mockingbird");
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        LibraryCatalog library = new LibraryCatalog();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook(book);

        // Set book as unavailable
        book.setAvailable(false);
        assertFalse(book.isAvailable());

        // Return the book
        library.returnBook("The Great Gatsby");
        assertTrue(book.isAvailable());
    }

    // Additional tests can be added to cover more scenarios as needed.
}