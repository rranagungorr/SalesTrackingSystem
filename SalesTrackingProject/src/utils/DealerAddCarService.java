package utils;

import CorePackage.Car;
import CorePackage.CarDatabase;
import CorePackage.Seller;

public class DealerAddCarService {

    public static boolean isCarInputValid(String model, String color, String priceText) {
        return !(model == null || model.isEmpty()
                || color == null || color.isEmpty()
                || priceText == null || priceText.isEmpty());
    }

    public static double parsePrice(String priceText) throws NumberFormatException {
        return Double.parseDouble(priceText);
    }

    public static int parseYear(String yearText) throws NumberFormatException {
        return Integer.parseInt(yearText);
    }

    public static Car createCar(String brand, String model, String color, String fuelType, double price, int sellerId) {
        return new Car(0, brand, model, color, fuelType, price, Car.available, sellerId);
    }

    public static boolean saveCar(Car car) {
        try {
            CarDatabase.addCar(car);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving car: " + e.getMessage());
            return false;
        }
    }
}
