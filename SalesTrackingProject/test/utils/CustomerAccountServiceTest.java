package utils;

import CorePackage.Customer;
import CorePackage.UserDatabase;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerAccountServiceTest {

    @Test
    public void testDeleteCustomerAccount_yes() {
        Customer customer = new Customer(0, "Test", "test_del_yes", "pass", "yes@test.com", "000");
        UserDatabase.addUser(customer);

        Customer inserted = (Customer) UserDatabase.getUserByUsername("test_del_yes");
        assertNotNull(inserted);

        boolean result = CustomerAccountService.deleteCustomerAccount(inserted, javax.swing.JOptionPane.YES_OPTION);
        assertTrue("User should be deleted", result);
        assertNull("User should no longer exist", UserDatabase.getUserById(inserted.getUserId()));
    }

    @Test
    public void testDeleteCustomerAccount_no() {
        Customer customer = new Customer(0, "Test", "test_del_no", "pass", "no@test.com", "000");
        UserDatabase.addUser(customer);

        Customer inserted = (Customer) UserDatabase.getUserByUsername("test_del_no");
        assertNotNull(inserted);

        boolean result = CustomerAccountService.deleteCustomerAccount(inserted, javax.swing.JOptionPane.NO_OPTION);
        assertFalse("User should NOT be deleted", result);
        assertNotNull("User should still exist", UserDatabase.getUserById(inserted.getUserId()));
    }

    @Test
    public void testGetCustomerInfoLabels() {
        Customer customer = new Customer(42, "Alice", "alice42", "pass", "alice@example.com", "123456");
        String[] actual = CustomerAccountService.getCustomerInfoLabels(customer);

        String[] expected = {
            String.valueOf(customer.getUserId()),
            customer.getName(),
            customer.getUsername(),
            customer.getPhone(),
            customer.getEmail()
        };

        assertArrayEquals("Customer info labels should match expected", expected, actual);
    }
}
