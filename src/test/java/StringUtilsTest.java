import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    private final StringUtils stringUtils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("nassin", stringUtils.reverse("nissan"));
        assertEquals("mercedes", stringUtils.reverse("sedecrem"));
        assertEquals("google", stringUtils.reverse("elgoog"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("civic"));
        assertTrue(stringUtils.isPalindrome(""));
        assertTrue(stringUtils.isPalindrome("level"));
        assertFalse(stringUtils.isPalindrome("apple"));
        assertFalse(stringUtils.isPalindrome("microsoft"));
    }

    @Test
    public void testConcatenate() {
        assertEquals("ToyotaLexus", stringUtils.concatenate("Toyota", "Lexus"));
        assertEquals("", stringUtils.concatenate("", ""));
        assertEquals("BMW", stringUtils.concatenate("BMW", ""));
        assertEquals("MicrosoftApple", stringUtils.concatenate("", "MicrosoftApple"));
    }

    @Test
    public void testCountOccurrences() {
        assertEquals(1, stringUtils.countOccurrences("tesla", 'a'));
        assertEquals(0, stringUtils.countOccurrences("jaguar", 'o'));
        assertEquals(2, stringUtils.countOccurrences("microsoft", 'o'));
        assertEquals(3, stringUtils.countOccurrences("canada", 'a'));
        assertEquals(0, stringUtils.countOccurrences("toyota", 'z'));
    }
}
