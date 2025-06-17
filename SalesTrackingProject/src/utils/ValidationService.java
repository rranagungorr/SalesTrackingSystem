package utils;

public class ValidationService {

    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^[A-Za-z]\\w{3,29}$");
    }

    public static boolean isValidPassword(String password) {
        return password != null &&
               password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z]{2,20}$");
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("^\\d{3}-\\d{3}-\\d{4}$");
    }
}

