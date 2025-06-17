package CorePackage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rana
 */
public class Customer extends User {

    private List<Car> listedCars = new ArrayList<>();

    // Constructor
    public Customer(int userId, String name, String username, String password, String email, String phone) {
        super(userId, name, username, password, email, phone, 2);
    }

    public Customer() {
        super();
        this.setRoleId(2);
    }

    // Getters and Setters
    public List<Car> getListedCars() {
        return listedCars;
    }

    public void setListedCars(List<Car> listedCars) {
        this.listedCars = listedCars;
    }

    // Customer-specific methods
    public void buyCar(Car car) {
        if (car != null && car.getStatus().equals(Car.available)) {
            car.setStatus(Car.pending);
            listedCars.add(car);
            System.out.println("Car purchase request submitted: " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("Car is not available for purchase.");
        }
    }

    public void cancelOrder(Car car) {
        if (listedCars.contains(car)) {
            car.setStatus(Car.available);
            listedCars.remove(car);
            System.out.println("Order canceled for car: " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("Car is not in your orders.");
        }
    }

    public void cancelAllOrders() {
        for (Car car : listedCars) {
            car.setStatus(Car.available);
        }
        listedCars.clear();
        System.out.println("All orders have been canceled.");
    }

    @Override
    public void deleteAccount() {

        OrderDatabase.cancelAllOrdersForCustomer(getUserId());

        super.deleteAccount();
    }

    @Override
    public String toString() {
        return "Customer{"
                + "userId=" + getUserId()
                + ", name='" + getName() + '\''
                + ", username='" + getUsername() + '\''
                + ", email='" + getEmail() + '\''
                + ", phone='" + getPhone() + '\''
                + ", roleId=" + getRoleId()
                + ", listedCars=" + listedCars
                + '}';
    }

}
