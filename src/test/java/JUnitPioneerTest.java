import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.ExpectedToFail;
import org.junitpioneer.jupiter.RetryingTest;
import org.productstar.User;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitPioneerTest {

    @ExpectedToFail("Jira-123")
    @Test
    void JUnitTestExpectToFail() {
        User user = new User("John", "Doe", 30);
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30, user.getAge(),  "Неправильный возраст")
        );
    }

    @RetryingTest(maxAttempts = 5)
    void JUnitTestMaxAttempts() {
        Random random = new Random();
        User user = new User("John", "Doe", 30);
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30 + random.nextInt(3), user.getAge(),  "Неправильный возраст")
        );
    }
}
