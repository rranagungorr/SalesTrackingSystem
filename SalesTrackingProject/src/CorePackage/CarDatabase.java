/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CorePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rana
 */
public class CarDatabase {

    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM Cars";

        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("car_id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getString("fuel_type"),
                        rs.getDouble("price"),
                        rs.getString("status"),
                        rs.getInt("seller_id")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching all cars.");
            e.printStackTrace();
        }

        return cars;
    }

    public static void addCar(Car car) {
        String query = "INSERT INTO Cars (brand, model, color, fuel_type, price, status, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getColor());
            stmt.setString(4, car.getFuelType());
            stmt.setDouble(5, car.getPrice());
            stmt.setString(6, car.getStatus());
            stmt.setInt(7, car.getSellerId());

            stmt.executeUpdate();
            System.out.println("Car added successfully!");
        } catch (SQLException e) {
            System.err.println("Error while adding car: " + car);
            e.printStackTrace();
        }
    }

    public static void updateCar(Car car) {
        String query = "UPDATE Cars SET brand = ?, model = ?, color = ?, fuel_type = ?, price = ?, status = ?, seller_id = ? WHERE car_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getColor());
            stmt.setString(4, car.getFuelType());
            stmt.setDouble(5, car.getPrice());
            stmt.setString(6, car.getStatus());
            stmt.setInt(7, car.getSellerId());
            stmt.setInt(8, car.getCarId());

            stmt.executeUpdate();
            System.out.println("Car updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error while updating car: " + car);
            e.printStackTrace();
        }
    }

    public static void deleteCar(int carId) {
        String query = "DELETE FROM Cars WHERE car_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, carId);
            stmt.executeUpdate();
            System.out.println("Car deleted successfully!");
        } catch (SQLException e) {
            System.err.println("Error while deleting car with ID: " + carId);
            e.printStackTrace();
        }
    }

    public static List<Car> listCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM Cars";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("car_id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getString("fuel_type"),
                        rs.getDouble("price"),
                        rs.getString("status"),
                        rs.getInt("seller_id")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            System.err.println("Error while listing cars.");
            e.printStackTrace();
        }
        return cars;
    }

    public static Car getCarById(int carId) {
        String query = "SELECT * FROM Cars WHERE car_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, carId);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Car(
                            rs.getInt("car_id"),
                            rs.getString("brand"),
                            rs.getString("model"),
                            rs.getString("color"),
                            rs.getString("fuel_type"),
                            rs.getDouble("price"),
                            rs.getString("status"),
                            rs.getInt("seller_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching car with ID: " + carId);
            e.printStackTrace();
        }
        return null; 
    }

    public static void updateCarStatus(int carId, String newStatus) {
        String query = "UPDATE Cars SET status = ? WHERE car_id = ?";

        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, carId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Car status updated successfully!");
            } else {
                System.out.println("Car not found or status not updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update car status.");
        }
    }

    public static void deleteAllCarsForSeller(int sellerId) {
        String query = "DELETE FROM Cars WHERE seller_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sellerId);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " cars deleted for seller ID: " + sellerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> getCarsBySellerId(int sellerId) {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM Cars WHERE seller_id = ?";

        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sellerId);
            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car(
                            rs.getInt("car_id"),
                            rs.getString("brand"),
                            rs.getString("model"),
                            rs.getString("color"),
                            rs.getString("fuel_type"),
                            rs.getDouble("price"),
                            rs.getString("status"),
                            rs.getInt("seller_id")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error fetching cars by seller ID: " + sellerId);
        }
        return cars;
    }

}
