package CorePackage;

import java.util.Arrays;

/**
 *
 * @author rana
 */
public class Car {

    public final static String[] carBrand = {"Togg", "Volkswagen", "Nissan", "Ford", "Toyata",
        "Honda", "Chevrolet", "Hyundai", "Renault", "Skoda", "Fiat", "Tata",
        "Jeep", "Ferrari", "Lamborghini", "Bugatti", "BMW", "Maruti", "Tesla"};

    public final static String[] carType = {"Hatchback", "Sedan", "MPV", "SUV", "Convertible",
        "Pickup", "Coupe"};

    public final static String[] carFuelType = {"Petrol", "Diesel", "Hybrid", "Electric"};

    public final static String pending = "Pending";
    public final static String accepted = "Accepted";
    public final static String available = "Available";
    public final static String denied = "Denied";

    private String register = available;

    private int carId;
    private String brand;
    private String model;
    private String color;
    private String fuelType;
    private double price;
    private String status;
    private int sellerId;

    public Car(int carId, String brand, String model, String color, String fuelType, double price, String status, int sellerId) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.price = price;
        this.status = status;
        this.sellerId = sellerId;
    }

    public Car() {
    }

    // Getters and Setters
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if (Arrays.asList(carFuelType).contains(fuelType)) {
            this.fuelType = fuelType;
        } else {
            throw new IllegalArgumentException("Invalid fuel type: " + fuelType);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

}
