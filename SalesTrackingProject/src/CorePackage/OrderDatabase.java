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
public class OrderDatabase {

    public static void addOrder(int customerId, int carId, String orderStatus) {
        String query = "INSERT INTO Orders (customer_id, car_id, order_status, order_date) VALUES (?, ?, ?, NOW())";

        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);       
            stmt.setInt(2, carId);            
            stmt.setString(3, orderStatus);   

            stmt.executeUpdate();
            System.out.println("Order added successfully!");
        } catch (SQLException e) {
            System.err.println("Error while adding order.");
            e.printStackTrace();
        }
        System.out.println("addOrder method called with customerId: " + customerId + ", carId: " + carId + ", orderStatus: " + orderStatus);

    }

    public static void updateOrderStatus(int orderId, String newStatus) {
        String query = "UPDATE Orders SET order_status = ? WHERE order_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, orderId);

            stmt.executeUpdate();
            System.out.println("Order status updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error while updating status for order ID: " + orderId);
            e.printStackTrace();
        }
    }


    public static void updateOrderStatusAndCar(int carId, String newStatus, int dealerId) {
        String updateOrderQuery = "UPDATE Orders SET order_status = ? WHERE car_id = ?";
        String updateCarQuery = "UPDATE Cars SET status = ? WHERE car_id = ?";

        try ( Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); 

            
            try ( PreparedStatement orderStmt = conn.prepareStatement(updateOrderQuery)) {
                orderStmt.setString(1, newStatus);
                orderStmt.setInt(2, carId);
                orderStmt.executeUpdate();
            }

       
            try ( PreparedStatement carStmt = conn.prepareStatement(updateCarQuery)) {
                String carStatus = newStatus.equals(Car.accepted) ? Car.accepted : Car.available;
                carStmt.setString(1, carStatus);
                carStmt.setInt(2, carId);
                carStmt.executeUpdate();
            }

            conn.commit(); 
            System.out.println("Order and car status updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error updating order and car status.");
            e.printStackTrace();
        }
    }

    public static void deleteOrder(int orderId) {
        String query = "DELETE FROM Orders WHERE order_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, orderId);

            stmt.executeUpdate();
            System.out.println("Order deleted successfully!");
        } catch (SQLException e) {
            System.err.println("Error while deleting order with ID: " + orderId);
            e.printStackTrace();
        }
    }

    public static List<Order> listOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("order_id"),
                        rs.getInt("car_id"),
                        rs.getInt("customer_id"),
                        rs.getString("order_status"),
                        rs.getString("order_date")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error while listing orders.");
            e.printStackTrace();
        }
        return orders;
    }

    public static Order getOrderById(int orderId) {
        String query = "SELECT * FROM Orders WHERE order_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, orderId);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Order(
                            rs.getInt("order_id"),
                            rs.getInt("car_id"),
                            rs.getInt("customer_id"),
                            rs.getString("order_status"),
                            rs.getString("order_date")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching order with ID: " + orderId);
            e.printStackTrace();
        }
        return null; 
    }

    public static void cancelAllOrdersForCustomer(int customerId) {
        String query = "DELETE FROM Orders WHERE customer_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " orders canceled for customer ID: " + customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
