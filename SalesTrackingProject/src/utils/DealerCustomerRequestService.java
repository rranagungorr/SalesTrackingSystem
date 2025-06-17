package utils;

import CorePackage.Car;
import CorePackage.Order;
import CorePackage.OrderDatabase;
import CorePackage.CarDatabase;
import CorePackage.Seller;
import CorePackage.User;
import CorePackage.UserDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DealerCustomerRequestService {

    public static List<Vector<Object>> getPendingCustomerRequests(Seller dealer) {
        List<Vector<Object>> rows = new ArrayList<>();

        List<Car> cars = CarDatabase.getCarsBySellerId(dealer.getUserId());
        List<Order> orders = OrderDatabase.listOrders();

        for (Car car : cars) {
            for (Order order : orders) {
                if (order.getCarId() == car.getCarId() && order.getOrderStatus().equals(Car.pending)) {
                    User customer = UserDatabase.getUserById(order.getCustomerId());
                    if (customer != null) {
                        Vector<Object> rowData = new Vector<>();
                        rowData.add(customer.getUserId());
                        rowData.add(customer.getUsername());
                        rowData.add(car.getCarId());
                        rowData.add(car.getBrand());
                        rowData.add(car.getModel());
                        rowData.add(car.getPrice());
                        rowData.add(order.getOrderStatus());
                        rows.add(rowData);
                    }
                }
            }
        }

        return rows;
    }

    public static boolean acceptOrDenyOrder(int carId, String newStatus, Seller dealer) {
        try {
            OrderDatabase.updateOrderStatusAndCar(carId, newStatus, dealer.getUserId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
