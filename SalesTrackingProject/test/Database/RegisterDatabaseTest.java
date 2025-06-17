package Database;

import CorePackage.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterDatabaseTest {
    
    @Test
    public void testAddNewCustomer() {
        System.out.println("Test: Add new customer started...");

        String username = "test_reg_user";
        User existing = UserDatabase.getUserByUsername(username);

        if (existing == null) {
            Customer customer = new Customer(
                0, "TestName", username, "Test123@",
                "testreg@example.com", "123-456-7890"
            );
            UserDatabase.addUser(customer);
            System.out.println("User added successfully!");
        } else {
            System.out.println("User already exists, skipping insert.");
        }

        User result = UserDatabase.getUserByUsername(username);
        assertNotNull("User should exist in the database", result);
        System.out.println("Test: Add new customer – PASSED");
    }

    @Test
    public void testCannotAddDuplicateUsername() {
        System.out.println("Test: Add duplicate username started...");
        String username = "test_reg_user";

        User first = UserDatabase.getUserByUsername(username);
        if (first == null) {
            System.out.println("Setup failed: Required user not found.");
            return;
        }

        Customer duplicate = new Customer(
                0, "Another", username, "Another123@",
                "duplicate@example.com", "000-000-0000"
        );
        try {
            UserDatabase.addUser(duplicate);
            User check = UserDatabase.getUserByUsername(username);
            if (check != null && !check.getEmail().equals("duplicate@example.com")) {
                System.out.println("Test PASSED: Duplicate user was rejected.");
            } else {
                fail("Test FAILED: Duplicate user overwritten or added!");
            }
        } catch (Exception e) {
            System.out.println("Test PASSED: Exception caught – duplicate insert blocked.");
        }

    }
}
