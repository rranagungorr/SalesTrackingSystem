package utils;

import CorePackage.*;

import java.util.List;
import java.util.Vector;

public class AdminPanelService {

    public static List<User> getUsersByRole(String role) {
        return UserDatabase.getAllUsers().stream()
                .filter(u -> (role.equals("Customer") && u instanceof Customer) ||
                             (role.equals("Dealer") && u instanceof Seller))
                .toList();
    }

    public static List<Car> getAllCars() {
        return CarDatabase.getAllCars();
    }

    public static Vector<Object> convertUserToRow(User user) {
        Vector<Object> row = new Vector<>();
        row.add(user.getUserId());
        row.add(user.getName());
        row.add(user.getUsername());
        row.add(user.getEmail());
        row.add(user.getPhone());
        return row;
    }

    public static Vector<Object> convertCarToRow(Car car) {
        Vector<Object> row = new Vector<>();
        row.add(car.getCarId());
        User seller = UserDatabase.getUserById(car.getSellerId());
        row.add(seller != null ? seller.getName() : "Unknown");
        row.add(car.getBrand());
        row.add(car.getModel());
        row.add(car.getColor());
        row.add(car.getFuelType());
        row.add(car.getPrice());
        row.add(car.getStatus());
        return row;
    }
}
