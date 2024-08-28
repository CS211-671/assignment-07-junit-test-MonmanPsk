package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void init() {
        user = new User("user01", "plain-p@ssw0rd");
    }

    @Test
    @DisplayName("Username should equal")
    public void testIsUsername() {
        boolean actual = user.isUsername("user01");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password should set to new password")
    public void testSetPassword() {
        user.setPassword("newPlainPassword");
        boolean actual = user.validatePassword("newPlainPassword");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }
}