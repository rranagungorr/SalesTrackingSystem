package Database;

import CorePackage.*;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDatabaseTest {

    private static final String baseUsername = "test_user_20250617152127_417a4e";
    private static final String baseEmail = baseUsername + "@example.com";
    private static int createdUserId;

    @BeforeClass
    public static void setup() {
        System.out.println("🔧 Preparing test user...");

        Customer testUser = new Customer(0, "TestName", baseUsername, "Test123@", baseEmail, "123-456-7890");
        UserDatabase.addUser(testUser);

        User fetched = UserDatabase.getUserByUsername(baseUsername);
        assertNotNull("User should be created in setup", fetched);
        createdUserId = fetched.getUserId();
    }

    @Test
    public void test01_AddUser() {
        System.out.println("✅ testAddUser");
        User user = UserDatabase.getUserById(createdUserId);
        assertNotNull("User should be found after creation", user);
        assertEquals(baseUsername, user.getUsername());
    }

    @Test
    public void test02_GetUserById() {
        System.out.println("✅ testGetUserById");
        User user = UserDatabase.getUserById(createdUserId);
        assertNotNull("Should find user by ID", user);
        assertEquals(baseUsername, user.getUsername());
    }

    @Test
    public void test03_GetUserByUsername() {
        System.out.println("✅ testGetUserByUsername");
        User user = UserDatabase.getUserByUsername(baseUsername);
        assertNotNull("Should find user by username", user);
        assertEquals(createdUserId, user.getUserId());
    }

    @Test
    public void test04_UpdateUser() {
        System.out.println("✅ testUpdateUser");
        User user = UserDatabase.getUserById(createdUserId);
        user.setPhone("999-999-9999");
        UserDatabase.updateUser(user);

        User updated = UserDatabase.getUserById(createdUserId);
        assertEquals("999-999-9999", updated.getPhone());
    }

    @Test
    public void test05_LoginVerification() {
        System.out.println("✅ testLoginVerification");
        User loginUser = UserDatabase.loginVerification(baseUsername, "Test123@");
        assertNotNull("Login should succeed", loginUser);
        assertEquals(baseUsername, loginUser.getUsername());
    }

    @Test
    public void test06_ListUsers() {
        System.out.println("✅ testListUsers");
        List<User> users = UserDatabase.listUsers();
        assertTrue("Should have at least one user", users.size() > 0);
    }

    @Test
    public void test07_GetAllUsers() {
        System.out.println("✅ testGetAllUsers");
        List<User> users = UserDatabase.getAllUsers();
        assertNotNull("Should not return null", users);
    }

    @Test
    public void test08_DeleteUser() {
        System.out.println("✅ testDeleteUser");
        UserDatabase.deleteUser(createdUserId);
        User deleted = UserDatabase.getUserById(createdUserId);
        assertNull("User should be deleted", deleted);
    }
}
