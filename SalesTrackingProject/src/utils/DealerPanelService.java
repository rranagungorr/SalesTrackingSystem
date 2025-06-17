package utils;

import Main.MainFrame;

public class DealerPanelService {

    public static String getDealerWelcomeMessage() {
        return "Welcome " + MainFrame.instance.getAccount().getName() + " Dealer";
    }

    public static boolean confirmLogout(int option) {
        return option == javax.swing.JOptionPane.YES_OPTION;
    }
}
