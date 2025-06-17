package Database;

import CorePackage.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDatabaseTest {

    private static Seller testSeller;
    private static Customer testCustomer;
    private static Car testCar;
    private static int testCarId;
    private static int insertedOrderId;

    private static String sellerUsername;
    private static String customerUsername;

    @BeforeClass
    public static void setup() {
        System.out.println("\n🚀 Starting OrderDatabase tests...");

        String timestamp = String.valueOf(System.currentTimeMillis());

        sellerUsername = "seller_test_" + timestamp;
        customerUsername = "cust_test_" + timestamp;

        testSeller = new Seller(0, "TestSeller", sellerUsername, "Pass123@", sellerUsername + "@mail.com", "555-555-5555");
        testCustomer = new Customer(0, "TestCustomer", customerUsername, "Pass123@", customerUsername + "@mail.com", "123-456-7890");

        try {
            if (UserDatabase.getUserByUsername(testSeller.getUsername()) == null) {
                UserDatabase.addUser(testSeller);
            }
            testSeller = (Seller) UserDatabase.getUserByUsername(testSeller.getUsername());

            if (UserDatabase.getUserByUsername(testCustomer.getUsername()) == null) {
                UserDatabase.addUser(testCustomer);
            }
            testCustomer = (Customer) UserDatabase.getUserByUsername(testCustomer.getUsername());

            testCar = new Car(0, "TestBrand", "TestModel", "Red", "Gasoline", 15000, Car.available, testSeller.getUserId());

            CarDatabase.addCar(testCar);

            // Doğru ID’yi almak için yeniden kontrol
            for (Car c : CarDatabase.getCarsBySellerId(testSeller.getUserId())) {
                if (c.getModel().equals("TestModel") && c.getBrand().equals("TestBrand")) {
                    testCarId = c.getCarId();
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("⚠️ Setup failed.");
            e.printStackTrace();
        }
    }

    @Test
    public void test1_AddOrder() {
        OrderDatabase.addOrder(testCustomer.getUserId(), testCarId, Car.pending);

        List<Order> orders = OrderDatabase.listOrders();
        boolean found = false;

        for (Order o : orders) {
            if (o.getCustomerId() == testCustomer.getUserId() && o.getCarId() == testCarId) {
                insertedOrderId = o.getOrderId();
                found = true;
                break;
            }
        }

        assertTrue("Order should be added", found);
    }

    @Test
    public void test2_UpdateOrderStatus() {
        OrderDatabase.updateOrderStatus(insertedOrderId, Car.accepted);
        Order updated = OrderDatabase.getOrderById(insertedOrderId);
        assertEquals("Order status should be updated", Car.accepted, updated.getOrderStatus());
    }

    @Test
    public void test3_UpdateOrderStatusAndCar() {
        OrderDatabase.updateOrderStatusAndCar(testCarId, Car.accepted, testSeller.getUserId());
        Car updatedCar = CarDatabase.getCarById(testCarId);
        assertEquals("Car status should be updated to accepted", Car.accepted, updatedCar.getStatus());
    }

    @Test
    public void test4_GetOrderById() {
        Order order = OrderDatabase.getOrderById(insertedOrderId);
        assertNotNull("Order should be fetched by ID", order);
        assertEquals("Fetched order ID should match", insertedOrderId, order.getOrderId());
    }

    @Test
    public void test5_ListOrders() {
        List<Order> orders = OrderDatabase.listOrders();
        assertNotNull("Orders should not be null", orders);
        assertTrue("There should be at least one order", orders.size() > 0);
    }

    @Test
    public void test6_CancelAllOrdersForCustomer() {
        OrderDatabase.cancelAllOrdersForCustomer(testCustomer.getUserId());
        List<Order> orders = OrderDatabase.listOrders();
        boolean stillExists = orders.stream().anyMatch(o -> o.getCustomerId() == testCustomer.getUserId());
        assertFalse("All orders of the customer should be deleted", stillExists);
    }

    @AfterClass
    public static void teardown() {
        System.out.println("🧹 Cleaning up test data...");

        if (testCarId > 0) CarDatabase.deleteCar(testCarId);

        if (testSeller != null) testSeller.deleteAccount();
        if (testCustomer != null) testCustomer.deleteAccount();

        System.out.println("✅ Cleanup completed.");
    }
}
