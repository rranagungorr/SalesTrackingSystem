package utils;

import CorePackage.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

public class CustomerCarListServiceTest {

    static Seller testSeller;
    static Customer testCustomer;

    @BeforeClass
    public static void setup() {
        testSeller = new Seller(0, "DealerX", "dealer_x", "pass", "dealer@test.com", "111");
        UserDatabase.addUser(testSeller);
        testSeller = (Seller) UserDatabase.getUserByUsername("dealer_x");

        testCustomer = new Customer(0, "CustomerY", "cust_y", "pass", "cust@test.com", "222");
        UserDatabase.addUser(testCustomer);

        Car car1 = new Car(0, "Toyota", "SUV", "Red", "Petrol", 10000, Car.available, testSeller.getUserId());
        Car car2 = new Car(0, "BMW", "Sedan", "Blue", "Diesel", 15000, Car.available, testSeller.getUserId());
        CarDatabase.addCar(car1);
        CarDatabase.addCar(car2);
    }

    @Test
    public void testGetAllAvailableCars() {
        List<Car> cars = CustomerCarListService.getAllAvailableCars();
        assertFalse(cars.isEmpty());
    }

    @Test
    public void testGetAllSellers() {
        List<User> sellers = CustomerCarListService.getAllSellers();
        assertTrue(sellers.stream().anyMatch(s -> s.getUsername().equals("dealer_x")));
    }

    @Test
    public void testFilterCarsByBrand() {
        List<Car> filtered = CustomerCarListService.filterCarsByBrand("Toyota");
        assertFalse(filtered.isEmpty());
        assertEquals("Toyota", filtered.get(0).getBrand());
    }

    @Test
    public void testFilterCarsByFuel() {
        List<Car> filtered = CustomerCarListService.filterCarsByFuel("Diesel");
        assertFalse(filtered.isEmpty());
        assertEquals("Diesel", filtered.get(0).getFuelType());
    }

    @Test
    public void testFilterCarsByType() {
        List<Car> filtered = CustomerCarListService.filterCarsByType("Sedan");
        assertFalse(filtered.isEmpty());
        assertEquals("Sedan", filtered.get(0).getModel());
    }

    @Test
    public void testGetCarsBySellerName() {
        List<Car> cars = CustomerCarListService.getCarsBySellerName("DealerX");
        assertFalse(cars.isEmpty());
        assertEquals("DealerX", ((Seller) UserDatabase.getUserById(cars.get(0).getSellerId())).getName());
    }

    @Test
    public void testConvertCarToRow() {
        List<Car> cars = CarDatabase.getCarsBySellerId(testSeller.getUserId());
        Car car = cars.get(0);
        Vector<Object> row = CustomerCarListService.convertCarToRow(car, testSeller);
        assertEquals(car.getBrand(), row.get(3));
    }

    @Test
    public void testBuyCar() {
        List<Car> cars = CarDatabase.getCarsBySellerId(testSeller.getUserId());
        Car availableCar = null;
        for (Car c : cars) {
            if (c.getStatus().equals(Car.available)) {
                availableCar = c;
                break;
            }
        }
        assertNotNull("There should be at least one available car", availableCar);
        boolean result = CustomerCarListService.buyCar(testCustomer, availableCar);
        assertTrue(result);
    }
}
