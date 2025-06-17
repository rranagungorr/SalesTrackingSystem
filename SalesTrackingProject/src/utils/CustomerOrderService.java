package utils;

import CorePackage.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;


public class CustomerOrderService {
    public static List<Order> getOrdersForCustomer(int customerId) {
        return OrderDatabase.listOrders().stream()
                .filter(order -> order.getCustomerId() == customerId)
                .toList();
    }

    public static Seller getDealerForOrder(Order order) {
        Car car = CarDatabase.getCarById(order.getCarId());
        return (Seller) UserDatabase.getUserById(car.getSellerId());
    }

    public static boolean cancelOrderIfPending(int orderId) {
        Order order = OrderDatabase.getOrderById(orderId);
        if (order != null && "Pending".equalsIgnoreCase(order.getOrderStatus())) {
            OrderDatabase.deleteOrder(orderId);
            return true;
        }
        return false;
    }
}
