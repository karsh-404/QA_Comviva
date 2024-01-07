import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    private final EmailValidator emailValidator = new EmailValidator();

    @Test
    public void testValidEmail() {
        assertTrue(emailValidator.isValidEmail("utkarsh@reddit.com"));
        assertTrue(emailValidator.isValidEmail("utkarsh123@amazon.co.in"));
        assertFalse(emailValidator.isValidEmail("invalid_email"));
        assertFalse(emailValidator.isValidEmail("utkarsh@.com"));
    }

    @Test
    public void testComvivaCorporateEmail() {
        assertFalse(emailValidator.isCorporateEmail("ayush@hotmail.com"));
        assertTrue(emailValidator.isCorporateEmail("utkarsh@company.com"));
        assertFalse(emailValidator.isCorporateEmail("ayush@gmail.com"));
        assertFalse(emailValidator.isCorporateEmail("invalid_email"));
    }

    @Test
    public void testNullEmail() {
        assertFalse(emailValidator.isValidEmail(null));
        assertFalse(emailValidator.isCorporateEmail(null));
    }

    @Test
    public void testEmptyEmail() {
        assertFalse(emailValidator.isValidEmail(""));
        assertFalse(emailValidator.isCorporateEmail(""));
    }

    @Test
    public void testInvalidDomainCorporateEmail() {
        assertTrue(emailValidator.isCorporateEmail("utkarsh@anothercompany.com"));
        assertFalse(emailValidator.isCorporateEmail("employee@comviva.org"));
    }

    @Test
    public void testEmailWithSpecialCharacters() {
        assertTrue(emailValidator.isValidEmail("user.name@yahoo.com"));
        assertFalse(emailValidator.isCorporateEmail("user.name@example.com"));
    }

    @Test
    public void testEmailWithMultipleDots() {
        assertTrue(emailValidator.isValidEmail("utkarsh.123@sub.domain.comviva.com"));
        assertFalse(emailValidator.isCorporateEmail("utkarsh.456@sub.domain.abc.com"));
    }

    @Test
    public void testEmailWithInvalidTLD() {
        assertFalse(emailValidator.isValidEmail("utkarsh@outlook.c"));
        assertFalse(emailValidator.isCorporateEmail("employee@comviva.c"));
    }
}
