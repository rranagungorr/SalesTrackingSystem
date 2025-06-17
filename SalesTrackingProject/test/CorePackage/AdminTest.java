package CorePackage;

import org.junit.*;

import static org.junit.Assert.*;

public class AdminTest {

    private static String testSellerUsername;
    private static String testCustomerUsername;
    private static Admin admin;

    @BeforeClass
    public static void setup() {
        admin = new Admin();

        String unique = String.valueOf(System.currentTimeMillis()); // benzersiz ID üret
        testSellerUsername = "delete_test_seller_" + unique;
        testCustomerUsername = "delete_test_customer_" + unique;

        // Seller oluştur
        Seller seller = new Seller(0, "Seller Name", testSellerUsername, "Pass123@", testSellerUsername + "@test.com", "123456");
        UserDatabase.addUser(seller);
        assertNotNull("Seller creation failed in setup", UserDatabase.getUserByUsername(testSellerUsername));

        // Customer oluştur
        Customer customer = new Customer(0, "Customer Name", testCustomerUsername, "Pass123@", testCustomerUsername + "@test.com", "654321");
        UserDatabase.addUser(customer);
        assertNotNull("Customer creation failed in setup", UserDatabase.getUserByUsername(testCustomerUsername));
    }

    @Test
    public void testDeleteSellerAccount() {
        User user = UserDatabase.getUserByUsername(testSellerUsername);
        assertNotNull("Seller must exist before deletion", user);

        admin.deleteUserAccount(testSellerUsername);
        User deleted = UserDatabase.getUserByUsername(testSellerUsername);
        assertNull("Seller must be deleted", deleted);
    }

    @Test
    public void testDeleteCustomerAccount() {
        User user = UserDatabase.getUserByUsername(testCustomerUsername);
        assertNotNull("Customer must exist before deletion", user);

        admin.deleteUserAccount(testCustomerUsername);
        User deleted = UserDatabase.getUserByUsername(testCustomerUsername);
        assertNull("Customer must be deleted", deleted);
    }

    @Test
    public void testDeleteNonexistentUser() {
        admin.deleteUserAccount("non_existing_user_xyz");
        assertNull("No user should be found", UserDatabase.getUserByUsername("non_existing_user_xyz"));
    }
}
