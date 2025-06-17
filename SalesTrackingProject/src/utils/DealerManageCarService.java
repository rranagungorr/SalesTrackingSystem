package utils;

import CorePackage.Car;
import CorePackage.CarDatabase;

import java.util.List;

public class DealerManageCarService {

    public static List<Car> getCarsByDealer(int dealerId) {
        return CarDatabase.getCarsBySellerId(dealerId);
    }

    public static boolean canDeleteCar(Car car) {
        if (car == null) return false;

        return !(car.getStatus().equalsIgnoreCase(Car.pending)
                || car.getStatus().equalsIgnoreCase(Car.accepted));
    }

    public static boolean deleteCarIfAllowed(Car car) {
        if (canDeleteCar(car)) {
            CarDatabase.deleteCar(car.getCarId());
            return true;
        }
        return false;
    }
}
