package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList users;

    @BeforeEach
    void init() {
        users = new UserList();
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        users.addUser("Mon", "1234");
        users.addUser("Man", "5678");
        users.addUser("Monman", "9999");

        // TODO: find one of them
        User user = users.findUserByUsername("Monman");

        // TODO: assert that UserList found User
         String expected = "Monman";
         String actual = user.getUsername();
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        users.addUser("Mon", "1234");
        users.addUser("Man", "5678");
        users.addUser("Monman", "9999");

        // TODO: change password of one user
        boolean actual = users.changePassword("Man", "5678", "8765");

        // TODO: assert that user can change password
         assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        users.addUser("Mon", "1234");
        users.addUser("Man", "5678");
        users.addUser("Monman", "9999");

        // TODO: call login() with correct username and password
        User expected = users.findUserByUsername("Mon");
        User actual = users.login("Mon", "1234");

        // TODO: assert that User object is found
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        users.addUser("Mon", "1234");
        users.addUser("Man", "5678");
        users.addUser("Monman", "9999");

        // TODO: call login() with incorrect username or incorrect password
        User actual = users.login("Mon", "12345");

        // TODO: assert that the method return null
         assertNull(actual);
    }

}