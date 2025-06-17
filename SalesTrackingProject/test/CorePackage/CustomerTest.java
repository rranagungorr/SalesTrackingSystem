package CorePackage;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

public class CustomerTest {

    private Customer customer;
    private Car testCar1;
    private Car testCar2;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setUserId(100);  // varsayılan test user ID
        testCar1 = new Car(1, "Toyota", "Corolla", "Red", "Gasoline", 20000.0, Car.available, 101);
        testCar2 = new Car(2, "Honda", "Civic", "Blue", "Hybrid", 22000.0, Car.available, 101);
    }

    @Test
    public void testBuyCar_success() {
        customer.buyCar(testCar1);

        List<Car> orders = customer.getListedCars();
        assertTrue("Car should be in listedCars", orders.contains(testCar1));
        assertEquals("Car status should be 'Pending'", Car.pending, testCar1.getStatus());
    }

    @Test
    public void testBuyCar_notAvailable() {
        testCar1.setStatus(Car.denied); // satın alınamaz hale getir
        customer.buyCar(testCar1);

        List<Car> orders = customer.getListedCars();
        assertFalse("Car should not be added if not available", orders.contains(testCar1));
    }

    @Test
    public void testCancelOrder_success() {
        customer.buyCar(testCar1); // önce satın al
        customer.cancelOrder(testCar1);

        List<Car> orders = customer.getListedCars();
        assertFalse("Car should be removed after canceling", orders.contains(testCar1));
        assertEquals("Car status should be reset to 'Available'", Car.available, testCar1.getStatus());
    }

    @Test
    public void testCancelOrder_notInList() {
        customer.cancelOrder(testCar2); // hiç eklenmemiş bir araba

        List<Car> orders = customer.getListedCars();
        assertFalse("Canceling non-existent car should do nothing", orders.contains(testCar2));
    }

    @Test
    public void testCancelAllOrders() {
        customer.buyCar(testCar1);
        customer.buyCar(testCar2);

        customer.cancelAllOrders();
        List<Car> orders = customer.getListedCars();

        assertTrue("All cars should be removed", orders.isEmpty());
        assertEquals("Car1 should be available", Car.available, testCar1.getStatus());
        assertEquals("Car2 should be available", Car.available, testCar2.getStatus());
    }
}
