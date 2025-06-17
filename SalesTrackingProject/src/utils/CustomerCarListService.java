package utils;

import CorePackage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CustomerCarListService {

    public static List<Car> getAllAvailableCars() {
        return CarDatabase.getAllCars();
    }

    public static List<User> getAllSellers() {
        List<User> sellers = new ArrayList<>();
        for (User user : UserDatabase.getAllUsers()) {
            if (user instanceof Seller) {
                sellers.add(user);
            }
        }
        return sellers;
    }

    public static Vector<Object> convertCarToRow(Car car, Seller seller) {
        Vector<Object> row = new Vector<>();
        row.add(seller.getUserId());
        row.add(seller.getName());
        row.add(car.getCarId());
        row.add(car.getBrand());
        row.add(car.getModel());
        row.add(car.getColor());
        row.add(car.getFuelType());
        row.add(car.getPrice());
        row.add(car.getStatus());
        return row;
    }

    public static List<Car> filterCarsByBrand(String brand) {
        List<Car> all = CarDatabase.getAllCars();
        List<Car> filtered = new ArrayList<>();
        for (Car car : all) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                filtered.add(car);
            }
        }
        return filtered;
    }

    public static List<Car> filterCarsByFuel(String fuel) {
        List<Car> all = CarDatabase.getAllCars();
        List<Car> filtered = new ArrayList<>();
        for (Car car : all) {
            if (car.getFuelType().equalsIgnoreCase(fuel)) {
                filtered.add(car);
            }
        }
        return filtered;
    }

    public static List<Car> filterCarsByType(String type) {
        List<Car> all = CarDatabase.getAllCars();
        List<Car> filtered = new ArrayList<>();
        for (Car car : all) {
            if (car.getModel().equalsIgnoreCase(type)) {
                filtered.add(car);
            }
        }
        return filtered;
    }

    public static List<Car> getCarsBySellerName(String sellerName) {
        for (User user : UserDatabase.getAllUsers()) {
            if (user instanceof Seller && user.getName().equalsIgnoreCase(sellerName)) {
                return CarDatabase.getCarsBySellerId(user.getUserId());
            }
        }
        return new ArrayList<>();
    }

    public static boolean buyCar(Customer customer, Car car) {
        if (car.getStatus().equals(Car.available)) {
            CarDatabase.updateCarStatus(car.getCarId(), Car.pending);
            OrderDatabase.addOrder(customer.getUserId(), car.getCarId(), Car.pending);
            return true;
        }
        return false;
    }
}

