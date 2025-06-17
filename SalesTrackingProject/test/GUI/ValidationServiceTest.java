package GUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ValidationService;
import static org.junit.Assert.*;

public class ValidationServiceTest {

    public ValidationServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting ValidationService tests...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("ValidationService tests completed.");
    }

    @Before
    public void setUp() {
        // Setup işlemleri (gerekirse)
    }

    @After
    public void tearDown() {
        // Temizlik işlemleri (gerekirse)
    }

    @Test
    public void testIsValidUsername() {
        System.out.println("Testing isValidUsername...");
        assertTrue(ValidationService.isValidUsername("john_doe"));
        assertFalse(ValidationService.isValidUsername("1john"));
        assertFalse(ValidationService.isValidUsername("jo"));
        assertFalse(ValidationService.isValidUsername(null));
    }

    @Test
    public void testIsValidPassword() {
        System.out.println("Testing isValidPassword...");
        assertTrue(ValidationService.isValidPassword("Aa1@aaaa"));
        assertFalse(ValidationService.isValidPassword("123")); // too short
        assertFalse(ValidationService.isValidPassword("noSpecialChar1A")); // no special char
        assertFalse(ValidationService.isValidPassword("NoDigits!")); // no digit
        assertFalse(ValidationService.isValidPassword(null));
    }

    @Test
    public void testIsValidEmail() {
        System.out.println("Testing isValidEmail...");
        assertTrue(ValidationService.isValidEmail("john@example.com"));
        assertFalse(ValidationService.isValidEmail("@example.com")); // starts with special char
        assertFalse(ValidationService.isValidEmail("johnexample.com")); // no @
        assertFalse(ValidationService.isValidEmail(null));
    }

    @Test
    public void testIsValidName() {
        System.out.println("Testing isValidName...");
        assertTrue(ValidationService.isValidName("Ali"));
        assertFalse(ValidationService.isValidName("A")); // too short
        assertFalse(ValidationService.isValidName("Ali!")); // special character
        assertFalse(ValidationService.isValidName("VeryLongNameThatExceeds")); // too long
        assertFalse(ValidationService.isValidName(null));
    }

    @Test
    public void testIsValidPhoneNumber() {
        System.out.println("Testing isValidPhoneNumber...");
        assertTrue(ValidationService.isValidPhoneNumber("123-456-7890"));
        assertFalse(ValidationService.isValidPhoneNumber("1234567890"));
        assertFalse(ValidationService.isValidPhoneNumber("abc-def-ghij"));
        assertFalse(ValidationService.isValidPhoneNumber(null));
    }
}
