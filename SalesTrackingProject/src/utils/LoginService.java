package utils;

import java.util.regex.*;
import CorePackage.User;
import CorePackage.UserDatabase;
/**
 *
 * @author rana-rumeysa
 */
public class LoginService {
    
    public User login(String username, String password) {
        // Gerçek sistemde veritabanı çağrısı
        return UserDatabase.loginVerification(username, password);
    }

    public boolean isInputValid(String username, String password) {
        return username != null && !username.isEmpty() &&
               password != null && !password.isEmpty();
    }

    public static boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.matches("^[A-Za-z]\\w{3,29}$");
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
    }

    public static boolean areCredentialsValid(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}