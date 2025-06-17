package mocktests;

import CorePackage.User;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import utils.LoginService;

public class LoginServiceMockTest {

    @Test
    public void testLoginSuccessMock() {
        // Mock bir User nesnesi oluştur
        User mockUser = mock(User.class);

        // LoginService mock'u
        LoginService mockService = mock(LoginService.class);

        // Mock davranışı tanımla
        when(mockService.login("testuser", "Aa1@aaaa")).thenReturn(mockUser);

        // Test et
        User result = mockService.login("testuser", "Aa1@aaaa");
        assertNotNull("Login başarılı olmalı", result);
    }

    @Test
    public void testLoginFailMock() {
        LoginService mockService = mock(LoginService.class);

        // Hatalı kullanıcıya null dön
        when(mockService.login("wronguser", "wrongpass")).thenReturn(null);

        User result = mockService.login("wronguser", "wrongpass");
        assertNull("Login başarısız olmalı", result);
    }
}


