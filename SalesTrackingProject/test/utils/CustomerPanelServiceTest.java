package utils;

import CorePackage.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerPanelServiceTest {

    @Test
    public void testWelcomeMessage() {
        Customer customer = new Customer(1, "Alice", "alice_user", "pass", "alice@test.com", "123456");
        String msg = CustomerPanelService.getCustomerWelcomeMessage(customer);
        assertTrue(msg.contains("Welcome Alice Customer"));
        System.out.println(" testWelcomeMessage PASSED");
    }

    @Test
    public void testConfirmLogout_yesOption() {
        assertTrue(CustomerPanelService.confirmLogout(javax.swing.JOptionPane.YES_OPTION));
        System.out.println(" testConfirmLogout_yesOption PASSED");
    }

    @Test
    public void testConfirmLogout_noOption() {
        assertFalse(CustomerPanelService.confirmLogout(javax.swing.JOptionPane.NO_OPTION));
        System.out.println(" testConfirmLogout_noOption PASSED");
    }
}
