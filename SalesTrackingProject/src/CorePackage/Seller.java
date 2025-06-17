package CorePackage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rana
 */
public class Seller extends User {

    private List<Car> listedCars = new ArrayList<>();

    // Constructor
    public Seller(int userId, String name, String username, String password, String email, String phone) {
        super(userId, name, username, password, email, phone, 1);
    }

    public Seller() {
        super();
        this.setRoleId(1);
    }

    // Getters and Setters
    public List<Car> getListedCars() {
        return listedCars;
    }

    public void setListedCars(List<Car> listedCars) {
        this.listedCars = listedCars;
    }

    // Seller-specific methods
    public void addCar(Car car) {
        if (car != null) {
            car.setSellerId(this.getUserId()); 
            car.setStatus(Car.available); 
            CarDatabase.addCar(car); 
            listedCars.add(car); 
            System.out.println("Car added: " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("Invalid car.");
        }
    }

    public void removeCar(int carId) {
        Car car = CarDatabase.getCarById(carId); 
        if (car != null && car.getSellerId() == this.getUserId()) { 
            if (car.getStatus().equals(Car.pending)) {
                System.out.println("Cannot remove car with pending status.");
                return;
            }
            CarDatabase.deleteCar(carId);
            listedCars.remove(car); 
            System.out.println("Car removed: " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("Car not found or not authorized to remove.");
        }
    }

    public void acceptOrder(int carId) {
        Car car = CarDatabase.getCarById(carId); 
        if (car != null && car.getSellerId() == this.getUserId() && car.getStatus().equals(Car.pending)) {
            car.setStatus(Car.accepted); 
            CarDatabase.updateCarStatus(carId, Car.accepted); 
            System.out.println("Order accepted for car: " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("Cannot accept order. Invalid car or status.");
        }
    }

    public void denyOrder(int carId) {
        Car car = CarDatabase.getCarById(carId); 
        if (car != null && car.getSellerId() == this.getUserId() && car.getStatus().equals(Car.pending)) {
            car.setStatus(Car.denied); 
            CarDatabase.updateCarStatus(carId, Car.denied); 
            System.out.println("Order denied for car: " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("Cannot deny order. Invalid car or status.");
        }
    }
    
    @Override
    public void deleteAccount() {
       
        CarDatabase.deleteAllCarsForSeller(getUserId());

        
        super.deleteAccount();
    }

    @Override
    public String toString() {
        return "Seller{"
                + "userId=" + getUserId()
                + ", name='" + getName() + '\''
                + ", username='" + getUsername() + '\''
                + ", email='" + getEmail() + '\''
                + ", phone='" + getPhone() + '\''
                + ", listedCars=" + listedCars
                + '}';
    }

}
