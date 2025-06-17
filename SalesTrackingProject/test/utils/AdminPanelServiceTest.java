package utils;

import CorePackage.*;
import org.junit.*;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

public class AdminPanelServiceTest {

    static Customer testCustomer;
    static Seller testSeller;
    static Car testCar;

    @BeforeClass
    public static void setup() {
        long ts = System.currentTimeMillis();
        testCustomer = new Customer(0, "A", "test_cus_" + ts, "123", "a@a.com", "000");
        testSeller = new Seller(0, "S", "test_sel_" + ts, "123", "s@s.com", "111");

        UserDatabase.addUser(testCustomer);
        UserDatabase.addUser(testSeller);

        testCustomer = (Customer) UserDatabase.getUserByUsername(testCustomer.getUsername());
        testSeller = (Seller) UserDatabase.getUserByUsername(testSeller.getUsername());

        testCar = new Car(0, "Toyota", "Yaris", "White", "Petrol", 10000, Car.available, testSeller.getUserId());
        CarDatabase.addCar(testCar);
    }

    @Test
    public void testGetUsersByRole() {
        List<User> customers = AdminPanelService.getUsersByRole("Customer");
        assertTrue(customers.stream().anyMatch(u -> u.getUsername().equals(testCustomer.getUsername())));

        List<User> sellers = AdminPanelService.getUsersByRole("Dealer");
        assertTrue(sellers.stream().anyMatch(u -> u.getUsername().equals(testSeller.getUsername())));
    }

    @Test
    public void testConvertUserToRow() {
        Vector<Object> row = AdminPanelService.convertUserToRow(testCustomer);
        assertEquals(testCustomer.getUsername(), row.get(2));
    }

    @Test
    public void testConvertCarToRow() {
        Car fresh = CarDatabase.getCarsBySellerId(testSeller.getUserId()).get(0);
        Vector<Object> row = AdminPanelService.convertCarToRow(fresh);
        assertEquals(fresh.getModel(), row.get(3));
    }

    @AfterClass
    public static void cleanup() {
        CarDatabase.deleteAllCarsForSeller(testSeller.getUserId());
        testCustomer.deleteAccount();
        testSeller.deleteAccount();
    }
}
