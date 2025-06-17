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
public class UserDatabase {

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";

        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int roleId = rs.getInt("role_id");
                if (roleId == 1) { // Seller
                    users.add(new Seller(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("phonenumber")
                    ));
                } else if (roleId == 2) { // Customer
                    users.add(new Customer(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("phonenumber")
                    ));
                } else if (roleId == 3) { // Admin
                    users.add(new Admin(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("phonenumber")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching all users.");
            e.printStackTrace();
        }

        return users;
    }

    public static void addUser(User user) {
        String query = "INSERT INTO Users (name, username, password, email, phonenumber, role_id) VALUES (?, ?, ?, ?, ?, ?)";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setInt(6, user.getRoleId());

            stmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.err.println("Error while adding user: " + user.getUsername());
            
        }
    }

    public static void updateUser(User user) {
        String query = "UPDATE Users SET name = ?, username = ?, password = ?, email = ?, phonenumber = ?, role_id = ? WHERE user_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setInt(6, user.getRoleId());
            stmt.setInt(7, user.getUserId());

            stmt.executeUpdate();
            System.out.println("User updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error while updating user with ID: " + user.getUserId());
            e.printStackTrace();
        }
    }

    public static void deleteUser(int userId) {
        String query = "DELETE FROM Users WHERE user_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();
            System.out.println("User deleted successfully!");
        } catch (SQLException e) {
            System.err.println("Error while deleting user with ID: " + userId);
            e.printStackTrace();
        }
    }

    public static List<User> listUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getInt("role_id")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error while listing users.");
            e.printStackTrace();
        }
        return users;
    }

    public static User getUserById(int userId) {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int roleId = rs.getInt("role_id");
                    if (roleId == 1) { // Seller
                        return new Seller(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getString("phonenumber")
                        );
                    } else if (roleId == 2) { // Customer
                        return new Customer(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getString("phonenumber")
                        );
                    } else if (roleId == 3) { // Admin
                        return new Admin(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getString("phonenumber")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching user with ID: " + userId);
            e.printStackTrace();
        }
        return null;
    }

    public static User getUserByUsername(String username) {
        String query = "SELECT * FROM Users WHERE username = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String userUsername = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phonenumber");
                int roleId = rs.getInt("role_id");

                
                if (roleId == 1) { // Seller
                    return new Seller(userId, name, userUsername, password, email, phone);
                } else if (roleId == 2) { // Customer
                    return new Customer(userId, name, userUsername, password, email, phone);
                } else if (roleId == 3) { // Admin
                    return new Admin(userId, name, userUsername, password, email, phone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User loginVerification(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try ( Connection conn = DatabaseConnection.getConnection();  PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int userId = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String userUsername = rs.getString("username");
                    String userPassword = rs.getString("password");
                    String email = rs.getString("email");
                    String phone = rs.getString("phonenumber");
                    int roleId = rs.getInt("role_id");

                   
                    if (roleId == 1) {
                        return new Seller(userId, name, userUsername, userPassword, email, phone);
                    } else if (roleId == 2) {
                        return new Customer(userId, name, userUsername, userPassword, email, phone);
                    } else if (roleId == 3) {
                        return new Admin(userId, name, userUsername, userPassword, email, phone);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
