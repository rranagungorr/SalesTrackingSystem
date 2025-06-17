package Database;

import CorePackage.Car;
import CorePackage.CarDatabase;
import CorePackage.Seller;
import CorePackage.UserDatabase;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarDatabaseTest {

    static int testSellerId;

    @BeforeClass
    public static void setup() {
        // Seller varsa al, yoksa oluştur
        String username = "car_test_seller";
        Seller existing = (Seller) UserDatabase.getUserByUsername(username);
        if (existing == null) {
            Seller seller = new Seller(0, "Test Seller", username, "Test123@", "seller@test.com", "123-456-7890");
            UserDatabase.addUser(seller);
            existing = (Seller) UserDatabase.getUserByUsername(username);
        }
        testSellerId = existing.getUserId();
    }

    @Test
    public void testAddAndGetCar() {
        Car car = new Car(0, "Toyota", "Corolla", "Red", "Gasoline", 15000, Car.available, testSellerId);
        CarDatabase.addCar(car);

        List<Car> cars = CarDatabase.getCarsBySellerId(testSellerId);
        assertFalse("Should return at least one car", cars.isEmpty());
        System.out.println("testAddAndGetCar passed.");
    }

    @Test
    public void testUpdateCarStatus() {
        Car car = new Car(0, "Honda", "Civic", "Black", "Diesel", 18000, Car.available, testSellerId);
        CarDatabase.addCar(car);

        List<Car> cars = CarDatabase.getCarsBySellerId(testSellerId);
        Car latest = cars.get(cars.size() - 1);

        CarDatabase.updateCarStatus(latest.getCarId(), Car.pending);
        Car updated = CarDatabase.getCarById(latest.getCarId());

        assertEquals(Car.pending, updated.getStatus());
        System.out.println("testUpdateCarStatus passed.");
    }

    @Test
    public void testUpdateCarDetails() {
        Car car = new Car(0, "Ford", "Focus", "Blue", "Gasoline", 20000, Car.available, testSellerId);
        CarDatabase.addCar(car);

        List<Car> cars = CarDatabase.getCarsBySellerId(testSellerId);
        Car toUpdate = cars.get(cars.size() - 1);

        toUpdate.setColor("Green");
        toUpdate.setPrice(21000);
        CarDatabase.updateCar(toUpdate);

        Car updated = CarDatabase.getCarById(toUpdate.getCarId());
        assertEquals("Green", updated.getColor());
        assertEquals(21000, updated.getPrice(), 0.001);
        System.out.println("testUpdateCarDetails passed.");
    }

    @Test
    public void testDeleteCar() {
        Car car = new Car(0, "Mazda", "3", "White", "Hybrid", 22000, Car.available, testSellerId);
        CarDatabase.addCar(car);

        List<Car> cars = CarDatabase.getCarsBySellerId(testSellerId);
        Car toDelete = cars.get(cars.size() - 1);

        CarDatabase.deleteCar(toDelete.getCarId());
        Car deleted = CarDatabase.getCarById(toDelete.getCarId());

        assertNull(deleted);
        System.out.println("testDeleteCar passed.");
    }

    @Test
    public void testDeleteAllCarsForSeller() {
        CarDatabase.deleteAllCarsForSeller(testSellerId);
        List<Car> cars = CarDatabase.getCarsBySellerId(testSellerId);
        assertTrue("All cars should be deleted", cars.isEmpty());
        System.out.println("testDeleteAllCarsForSeller passed.");
    }
}
