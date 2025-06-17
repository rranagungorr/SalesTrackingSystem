package utils;

import CorePackage.Seller;
import Main.MainFrame;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerPanelServiceTest {

    @BeforeClass
    public static void initMainFrame() {
        // Set up the MainFrame singleton for test context
        MainFrame.instance = new MainFrame();
        MainFrame.instance.setAccount(new Seller(1, "John", "john_seller", "pass", "john@example.com", "123456"));
    }

    @Test
    public void testWelcomeMessage() {
        String message = DealerPanelService.getDealerWelcomeMessage();
        assertTrue("Welcome message should contain dealer name", message.contains("Welcome John Dealer"));
        System.out.println(" testWelcomeMessage PASSED");
    }

    @Test
    public void testConfirmLogout_yesOption() {
        int yesOption = javax.swing.JOptionPane.YES_OPTION;
        boolean result = DealerPanelService.confirmLogout(yesOption);
        assertTrue("Logout confirmation should return true for YES_OPTION", result);
        System.out.println(" testConfirmLogout_yesOption PASSED");
    }

    @Test
    public void testConfirmLogout_noOption() {
        int noOption = javax.swing.JOptionPane.NO_OPTION;
        boolean result = DealerPanelService.confirmLogout(noOption);
        assertFalse("Logout confirmation should return false for NO_OPTION", result);
        System.out.println(" testConfirmLogout_noOption PASSED");
    }
}
