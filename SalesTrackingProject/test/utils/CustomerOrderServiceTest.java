package utils;

import CorePackage.*;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerOrderServiceTest {

    static Customer testCustomer;
    static Seller testSeller;
    static Car testCar1;
    static Car testCar2;

    @BeforeClass
    public static void setup() {
        // Create test seller
        testSeller = new Seller(0, "Seller Name", "seller_username", "pass", "seller@example.com", "111");
        UserDatabase.addUser(testSeller);
        testSeller = (Seller) UserDatabase.getUserByUsername("seller_username");

        // Create test customer
        testCustomer = new Customer(0, "Customer Name", "customer_username", "pass", "customer@example.com", "222");
        UserDatabase.addUser(testCustomer);
        testCustomer = (Customer) UserDatabase.getUserByUsername("customer_username");

        // Add test cars
        testCar1 = new Car(0, "Toyota", "Corolla", "Red", "Petrol", 15000, Car.available, testSeller.getUserId());
        testCar2 = new Car(0, "Honda", "Civic", "Blue", "Diesel", 18000, Car.available, testSeller.getUserId());
        CarDatabase.addCar(testCar1);
        CarDatabase.addCar(testCar2);

        // Refetch to get generated IDs
        List<Car> allCars = CarDatabase.getAllCars();
        testCar1 = allCars.get(allCars.size() - 2);
        testCar2 = allCars.get(allCars.size() - 1);

        // Add order
        OrderDatabase.addOrder(testCustomer.getUserId(), testCar1.getCarId(), Car.pending);
    }

    @Test
    public void testGetOrdersForCustomer() {
        List<Order> orders = CustomerOrderService.getOrdersForCustomer(testCustomer.getUserId());
        assertFalse("Should return at least one order", orders.isEmpty());
        for (Order order : orders) {
            assertEquals(testCustomer.getUserId(), order.getCustomerId());
        }
    }

    @Test
    public void testGetDealerForOrder() {
        List<Order> orders = CustomerOrderService.getOrdersForCustomer(testCustomer.getUserId());
        assertFalse("Orders should not be empty", orders.isEmpty());

        Seller dealer = CustomerOrderService.getDealerForOrder(orders.get(0));
        assertNotNull(dealer);
        assertEquals(testSeller.getUserId(), dealer.getUserId());
    }

    @Test
    public void testCancelOrderIfPending() {
        // Create a new pending order
        Car testCar = new Car(0, "Ford", "Focus", "Green", "Hybrid", 20000, Car.available, testSeller.getUserId());
        CarDatabase.addCar(testCar);
        List<Car> cars = CarDatabase.getAllCars();
        testCar = cars.get(cars.size() - 1);

        OrderDatabase.addOrder(testCustomer.getUserId(), testCar.getCarId(), Car.pending);
        List<Order> orders = CustomerOrderService.getOrdersForCustomer(testCustomer.getUserId());
        Order latestOrder = orders.get(orders.size() - 1);

        boolean result = CustomerOrderService.cancelOrderIfPending(latestOrder.getOrderId());
        assertTrue("Order should be canceled", result);
        assertNull(OrderDatabase.getOrderById(latestOrder.getOrderId()));
    }

    @Test
    public void testCancelOrderIfNotPending() {
        Car testCar = new Car(0, "Fiat", "Egea", "Grey", "Petrol", 10000, Car.available, testSeller.getUserId());
        CarDatabase.addCar(testCar);
        List<Car> cars = CarDatabase.getAllCars();
        testCar = cars.get(cars.size() - 1);

        OrderDatabase.addOrder(testCustomer.getUserId(), testCar.getCarId(), Car.accepted);
        List<Order> orders = CustomerOrderService.getOrdersForCustomer(testCustomer.getUserId());
        Order latestOrder = orders.get(orders.size() - 1);

        boolean result = CustomerOrderService.cancelOrderIfPending(latestOrder.getOrderId());
        assertFalse("Order should not be canceled", result);
    }
}
