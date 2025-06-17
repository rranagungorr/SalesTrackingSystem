package Database;

import CorePackage.DatabaseConnection;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DatabaseConnectionTest {

    @Test
    public void testConnectionIsNotNull() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            assertNotNull("Connection should not be null", conn);
            assertFalse("Connection should be open", conn.isClosed());
        } catch (Exception e) {
            fail("Connection failed: " + e.getMessage());
        }
    }
}
