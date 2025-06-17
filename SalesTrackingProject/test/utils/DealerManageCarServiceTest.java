package utils;

import CorePackage.Car;
import CorePackage.Seller;
import CorePackage.UserDatabase;
import CorePackage.CarDatabase;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DealerManageCarServiceTest {

    static Seller testSeller;

    @BeforeClass
    public static void setup() {
        // Satıcıyı kontrol et
        testSeller = (Seller) UserDatabase.getUserByUsername("dealer_manage_test");
        if (testSeller == null) {
            Seller s = new Seller(0, "Manage Tester", "dealer_manage_test", "pass", "dm@test.com", "000");
            UserDatabase.addUser(s);
            testSeller = (Seller) UserDatabase.getUserByUsername("dealer_manage_test");
            assertNotNull("Seller must be created", testSeller);
        }
    }

    @Test
    public void testGetCarsByDealer() {
        List<Car> cars = DealerManageCarService.getCarsByDealer(testSeller.getUserId());
        assertNotNull(cars);
    }

    @Test
    public void testCanDeleteCar_valid() {
        Car car = new Car(0, "BrandX", "ModelX", "Black", "Hybrid", 10000, Car.available, testSeller.getUserId());
        assertTrue(DealerManageCarService.canDeleteCar(car));
    }

    @Test
    public void testCanDeleteCar_pending() {
        Car car = new Car(0, "BrandY", "ModelY", "Red", "Diesel", 12000, Car.pending, testSeller.getUserId());
        assertFalse(DealerManageCarService.canDeleteCar(car));
    }

    @Test
    public void testDeleteCarIfAllowed_success() {
        Car car = new Car(0, "DelBrand", "DelModel", "White", "Petrol", 9000, Car.available, testSeller.getUserId());
        CarDatabase.addCar(car);
        List<Car> all = CarDatabase.getCarsBySellerId(testSeller.getUserId());
        Car latest = all.get(all.size() - 1);

        boolean deleted = DealerManageCarService.deleteCarIfAllowed(latest);
        assertTrue(deleted);
        assertNull(CarDatabase.getCarById(latest.getCarId()));
    }

    @Test
    public void testDeleteCarIfAllowed_fail_dueToPending() {
        Car car = new Car(0, "X", "Y", "Gray", "Electric", 13000, Car.pending, testSeller.getUserId());
        assertFalse(DealerManageCarService.deleteCarIfAllowed(car));
    }
}
