package utils;

import CorePackage.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DealerCustomerRequestServiceTest {

    private static Seller dealer;
    private static Customer customer;

    @BeforeClass
    public static void setup() {
        // Seller
        dealer = (Seller) UserDatabase.getUserByUsername("dealer_cr_test");
        if (dealer == null) {
            Seller newSeller = new Seller(0, "DealerCR", "dealer_cr_test", "pass", "dealer_cr@test.com", "000");
            boolean added = UserDatabase.addUser(newSeller);
            assertTrue("Seller should be added", added);
            dealer = (Seller) UserDatabase.getUserByUsername("dealer_cr_test");
            assertNotNull("Seller should exist", dealer);
        }

        // Customer
        customer = (Customer) UserDatabase.getUserByUsername("cust_cr_test");
        if (customer == null) {
            Customer newCustomer = new Customer(0, "CustomerCR", "cust_cr_test", "pass", "cust_cr@test.com", "111");
            boolean added = UserDatabase.addUser(newCustomer);
            assertTrue("Customer should be added", added);
            customer = (Customer) UserDatabase.getUserByUsername("cust_cr_test");
            assertNotNull("Customer should exist", customer);
        }
    }

    @Test
    public void testCustomerRequestFlow() {
        // Create car by dealer
        Car car = new Car(0, "TestBrand", "ModelX", "Gray", "Diesel", 20000, Car.available, dealer.getUserId());
        CarDatabase.addCar(car);
        List<Car> cars = CarDatabase.getCarsBySellerId(dealer.getUserId());
        assertFalse("Car list should not be empty", cars.isEmpty());

        Car latestCar = cars.get(cars.size() - 1);

        // Customer places an order
        OrderDatabase.addOrder(customer.getUserId(), latestCar.getCarId(), Car.pending);
        List<Order> orders = OrderDatabase.listOrders();
        boolean found = orders.stream().anyMatch(order ->
            order.getCarId() == latestCar.getCarId() &&
            order.getCustomerId() == customer.getUserId()
        );
        assertTrue("Order should be found", found);
    }
}
