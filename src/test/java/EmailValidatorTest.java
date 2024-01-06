import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    @Test
    public void testIsValidEmail() {
        EmailValidator validator = new EmailValidator();
        assertTrue(validator.isValidEmail("user@example.com"));
        assertTrue(validator.isValidEmail("john.doe@domain.co.uk"));
        assertFalse(validator.isValidEmail("invalid_email"));
        assertFalse(validator.isValidEmail("user@.com"));
    }

    @Test
    public void testIsCorporateEmail() {
        EmailValidator validator = new EmailValidator();
        assertFalse(validator.isCorporateEmail("user@example.com"));
        assertTrue(validator.isCorporateEmail("employee@company.com"));
        assertTrue(validator.isCorporateEmail("john.doe@anothercompany.com"));
        assertFalse(validator.isCorporateEmail("john.doe@company.com.invalid"));
    }
}