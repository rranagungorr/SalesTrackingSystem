package CorePackage;

import CorePackage.*;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SellerTest {

    private static final String uniqueUsername = "test_seller_20250617155021_b1tfce";
    private static final String uniqueEmail = uniqueUsername + "@example.com";
    private static int sellerId;
    private static int carId;
    private static Seller testSeller;

    @BeforeClass
    public static void setup() {
        System.out.println("🔧 Setting up test seller and car...");

        testSeller = new Seller(0, "TestSeller", uniqueUsername, "Test123@", uniqueEmail, "555-1234");
        UserDatabase.addUser(testSeller);

        User user = UserDatabase.getUserByUsername(uniqueUsername);
        assertNotNull("Seller should be created", user);
        sellerId = user.getUserId();
        testSeller.setUserId(sellerId);
    }

    @Test
    public void test01_AddCar() {
        Car car = new Car(0, "Toyota", "Corolla", "Blue", "Gasoline", 18000.00, Car.available, sellerId);
        testSeller.addCar(car);

        List<Car> cars = CarDatabase.getCarsBySellerId(sellerId);
        assertFalse("Car list should not be empty", cars.isEmpty());

        carId = cars.get(0).getCarId();
        assertEquals("Car brand should be Toyota", "Toyota", cars.get(0).getBrand());
    }

    @Test
    public void test02_RemoveCar_NotPending() {
        testSeller.removeCar(carId);
        Car removed = CarDatabase.getCarById(carId);
        assertNull("Car should be removed from DB", removed);
    }

    @Test
    public void test03_AddPendingCar_ThenDeny() {
        Car car = new Car(0, "Honda", "Civic", "Red", "Petrol", 20000.00, Car.pending, sellerId);
        CarDatabase.addCar(car);
        List<Car> cars = CarDatabase.getCarsBySellerId(sellerId);
        Car pendingCar = cars.stream().filter(c -> c.getStatus().equals(Car.pending)).findFirst().orElse(null);
        assertNotNull("Should find the pending car", pendingCar);

        testSeller.denyOrder(pendingCar.getCarId());

        Car updated = CarDatabase.getCarById(pendingCar.getCarId());
        assertEquals("Status should be denied", Car.denied, updated.getStatus());

        // cleanup
        CarDatabase.deleteCar(updated.getCarId());
    }

    @AfterClass
    public static void teardown() {
        System.out.println("🧹 Cleaning up Seller...");
        testSeller.deleteAccount();
    }
}
