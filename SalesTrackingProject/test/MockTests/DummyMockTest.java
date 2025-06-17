package mocktests;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DummyMockTest {

    public interface MyService {
        String greet();
    }

    @Test
    public void testMockitoBasic() {
        MyService mockService = mock(MyService.class);
        when(mockService.greet()).thenReturn("Hello");

        assertEquals("Hello", mockService.greet());
    }
}

