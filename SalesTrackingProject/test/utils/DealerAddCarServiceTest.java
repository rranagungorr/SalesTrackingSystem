package utils;

import CorePackage.Car;
import CorePackage.Seller;
import CorePackage.UserDatabase;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerAddCarServiceTest {

    static Seller testSeller;

    @BeforeClass
    public static void setup() {
        testSeller = new Seller(0, "TestDealer", "dealer_test", "pass", "dealer@test.com", "000");
        UserDatabase.addUser(testSeller);
        testSeller = (Seller) UserDatabase.getUserByUsername("dealer_test");
    }

    @Test
    public void testValidInput() {
        assertTrue(DealerAddCarService.isCarInputValid("ModelX", "Black", "25000"));
    }

    @Test
    public void testInvalidInput_emptyModel() {
        assertFalse(DealerAddCarService.isCarInputValid("", "Black", "25000"));
    }

    @Test
    public void testParsePrice_valid() {
        double price = DealerAddCarService.parsePrice("19999.99");
        assertEquals(19999.99, price, 0.01);
    }

    @Test(expected = NumberFormatException.class)
    public void testParsePrice_invalid() {
        DealerAddCarService.parsePrice("abc");
    }

    @Test
    public void testParseYear_valid() {
        int year = DealerAddCarService.parseYear("2022");
        assertEquals(2022, year);
    }

    @Test
    public void testCreateCar() {
        Car car = DealerAddCarService.createCar("Toyota", "Corolla", "Red", "Hybrid", 20000.0, testSeller.getUserId());
        assertEquals("Toyota", car.getBrand());
        assertEquals("Corolla", car.getModel());
        assertEquals("Red", car.getColor());
        assertEquals("Hybrid", car.getFuelType());
        assertEquals(Car.available, car.getStatus());
        assertEquals(testSeller.getUserId(), car.getSellerId());
    }

    @Test
    public void testSaveCar_success() {
        Car car = DealerAddCarService.createCar("TestBrand", "TestModel", "Blue", "Diesel", 15000.0, testSeller.getUserId());
        boolean saved = DealerAddCarService.saveCar(car);
        assertTrue(saved);
    }
}
