package utils;

import CorePackage.User;

public class CustomerPanelService {

    
    public static String getCustomerWelcomeMessage(User user) {
        return "Welcome " + user.getName() + " Customer";
    }

    
    public static boolean confirmLogout(int selectedOption) {
        return selectedOption == javax.swing.JOptionPane.YES_OPTION;
    }
}
