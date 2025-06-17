package utils;

import CorePackage.Car;
import CorePackage.CarDatabase;
import CorePackage.Seller;
import CorePackage.UserDatabase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DealerAccountServiceTest {

    private Seller testDealer;

    @Before
    public void setup() {
        testDealer = new Seller(42, "Jane Dealer", "jane_d", "pass", "jane@example.com", "123456789");

    }

    @Test
    public void testCanDeleteDealer_noPendingCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Corolla", "White", "Gasoline", 15000, Car.available, testDealer.getUserId()));
        cars.add(new Car(2, "Honda", "Civic", "Black", "Diesel", 17000, Car.accepted, testDealer.getUserId()));
        CarDatabase.deleteAllCarsForSeller(testDealer.getUserId());
        for (Car car : cars) {
            CarDatabase.addCar(car);
        }

        boolean canDelete = DealerAccountService.canDeleteDealer(testDealer);
        assertTrue("Dealer should be deletable", canDelete);
    }

    @Test
    public void testCanDeleteDealer_withPendingCar() {
        Seller testSeller = new Seller(0, "Blocked", "blocked_dealer", "pass", "blocked@example.com", "444");
        UserDatabase.addUser(testSeller); // ✔️ Make sure seller is in DB
        Seller persistedSeller = (Seller) UserDatabase.getUserByUsername("blocked_dealer");

        Car pendingCar = new Car(0, "Bugatti", "Chiron", "White", "Petrol", 3000000, Car.pending, persistedSeller.getUserId());
        CarDatabase.addCar(pendingCar); // ✅ Now works

        boolean result = DealerAccountService.canDeleteDealer(persistedSeller);
        assertFalse("Dealer with pending car should not be deletable", result);
    }

    @Test
    public void testGetDealerInfo() {
        String[] info = DealerAccountService.getDealerInfo(testDealer);

        assertEquals("42", info[0]);
        assertEquals("Jane Dealer", info[1]);
        assertEquals("jane_d", info[2]);
        assertEquals("123456789", info[3]);
        assertEquals("jane@example.com", info[4]);
    }
}
