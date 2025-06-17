package utils;

import CorePackage.Customer;
import CorePackage.UserDatabase;

public class CustomerAccountService {

    public static boolean deleteCustomerAccount(Customer customer, int userConfirmationOption) {
        if (userConfirmationOption == javax.swing.JOptionPane.YES_OPTION) {
            UserDatabase.deleteUser(customer.getUserId());
            return true;
        }
        return false;
    }

    public static String[] getCustomerInfoLabels(Customer customer) {
        return new String[]{
            String.valueOf(customer.getUserId()),
            customer.getName(),
            customer.getUsername(),
            customer.getPhone(),
            customer.getEmail()
        };
    }
}
