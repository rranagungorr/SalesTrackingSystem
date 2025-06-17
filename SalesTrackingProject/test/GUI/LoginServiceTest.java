package GUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.LoginService;
/**
 *
 * @author rana-rumeysa
 */
public class LoginServiceTest {

    public LoginServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting LoginService tests...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("LoginService tests completed.");
    }

    @Before
    public void setUp() {
        // Test öncesi hazırlık gerekirse buraya
    }

    @After
    public void tearDown() {
        // Test sonrası temizlik gerekirse buraya
    }

    @Test
    public void testValidUsername() {
        System.out.println("Testing valid usernames...");
        assertTrue(LoginService.isValidUsername("john_doe"));
        assertTrue(LoginService.isValidUsername("Ali123"));
        assertFalse(LoginService.isValidUsername("1john")); // sayı ile başlıyor
        assertFalse(LoginService.isValidUsername("a"));     // çok kısa
        assertFalse(LoginService.isValidUsername(null));
    }

    @Test
    public void testValidPassword() {
        System.out.println("Testing valid passwords...");
        assertTrue(LoginService.isValidPassword("Aa1@abcd"));
        assertFalse(LoginService.isValidPassword("abc"));            // çok kısa
        assertFalse(LoginService.isValidPassword("Password1"));      // özel karakter yok
        assertFalse(LoginService.isValidPassword("noDigits!"));      // rakam yok
        assertFalse(LoginService.isValidPassword("12345678!"));      // küçük/büyük harf yok
        assertFalse(LoginService.isValidPassword(null));
    }

    @Test
    public void testAreCredentialsValid() {
        System.out.println("Testing overall credential validation...");
        assertTrue(LoginService.areCredentialsValid("john_doe", "Aa1@aaaa"));
        assertFalse(LoginService.areCredentialsValid("john_doe", "12345678")); // geçersiz şifre
        assertFalse(LoginService.areCredentialsValid("1john", "Aa1@aaaa"));    // geçersiz kullanıcı
        assertFalse(LoginService.areCredentialsValid(null, null));
    }
}
