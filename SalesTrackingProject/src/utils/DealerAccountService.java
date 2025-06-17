package utils;

import CorePackage.Car;
import CorePackage.CarDatabase;
import CorePackage.Seller;

import java.util.List;

public class DealerAccountService {

    public static boolean canDeleteDealer(Seller dealer) {
        List<Car> cars = CarDatabase.getCarsBySellerId(dealer.getUserId());
        for (Car car : cars) {
            if (car.getStatus().equalsIgnoreCase(Car.pending)) {
                return false;
            }
        }
        return true;
    }

    public static String[] getDealerInfo(Seller dealer) {
        return new String[] {
            String.valueOf(dealer.getUserId()),
            dealer.getName(),
            dealer.getUsername(),
            dealer.getPhone(),
            dealer.getEmail()
        };
    }
}