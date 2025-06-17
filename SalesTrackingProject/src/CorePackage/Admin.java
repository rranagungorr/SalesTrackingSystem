package CorePackage;

/**
 *
 * @author rana
 */
public class Admin extends User {

    public Admin(int userId, String name, String username, String password, String email, String phone) {
        super(userId, name, username, password, email, phone, 3);
    }

    public Admin() {
        super();
        this.setRoleId(3); 
    }

    
    public void deleteUserAccount(String username) {
        User user = UserDatabase.getUserByUsername(username);

        if (user != null) {
            if (user instanceof Customer customer) {
                OrderDatabase.cancelAllOrdersForCustomer(customer.getUserId());
            } 
            else if (user instanceof Seller seller) {
                CarDatabase.deleteAllCarsForSeller(seller.getUserId());
            }

           
            UserDatabase.deleteUser(user.getUserId());
            System.out.println("User account deleted successfully: " + username);
        } else {
            System.out.println("User not found: " + username);
        }
    }

}
