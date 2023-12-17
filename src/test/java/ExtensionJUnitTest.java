import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.productstar.LifecycleExtension;
import org.productstar.ParameterExtension;
import org.productstar.User;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtensionJUnitTest {

    @ExtendWith(LifecycleExtension.class)
    @Test
    void JunitTestWithLifecycleExtend() {
        int actualSum = 1 + 1;
        int expectedSum = 2;
        assertEquals(expectedSum, actualSum);
        System.out.println("JunitTestWithExtend");
    }

    @ExtendWith(ParameterExtension.class)
    @Test
    void JunitTestWithParameterExtend(User user) {
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30, user.getAge(),  "Неправильный возраст")
        );
    }
}
